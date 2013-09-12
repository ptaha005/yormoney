define([
    "knockout",
    "jquery",
    "ko.mapping",
    "text!./../templates/Register2.html",
    "vent",
    "core"
    ], function(ko, $, komapping, template, vent, core){   

        //TODO : use Date on SERVER!!!!!!!


        var dateToString = function(d){
            if (!d) return '-';

            if (isNaN(d.getDate()) || isNaN(d.getMonth()) || isNaN(d.getFullYear())) return '-';

            return d.getDate() + '/' + (d.getMonth() + 1) + '/' + d.getFullYear();
        }

        var strToDate = function(str){
            if (str == null || str == '') return null;

            var parts = str.split('/');

            var day = parseInt(parts[0], 10);
            var month = parseInt(parts[1], 10);
            var year = parseInt(parts[2], 10);
            
            return new Date(year, month, day);   
        }

        var Member = function(data, relationships) {
            var self = this;
            komapping.fromJS(data, {   }, self);//todo: default object


            var relationship = data.relationship || { id : undefined, name : '-' };
            self.relationship = { 
                id : ko.observable(relationship.id),
                name : ko.observable(relationship.name)
            }

            

            self.firstName.extend({
                required: true
            });

            self.lastName.extend({
                required: true
            });
            
            self.email.extend({ 
                required: true, 
                email : {
                    message : 'please use valid email address'
                }, 
                minLength : 2, maxLength : 80 }); 

            self.errors = ko.validation.group(self);

            self.dateOfBirthAsDate = ko.observable(strToDate(data.dateOfBirth));
            self.dateOfBirth = ko.computed(function(){
                return dateToString(self.dateOfBirthAsDate());
            });

            self.accountHolderText = ko.computed(function() {
                return self.accountHolder() ? 'YES' : 'No';
            });  

        }



        // var Member = function(data){
        //     var self = core.Model(data, {
        //         url : '/member',
        //         fields : {
        //             relationship : { default: { id : undefined, name : '-' }},
        //             dateOfBirth : { source : function(value){ strToDate(value); } },
        //             firstName : { validation : { required: true }},
        //             lastName : { validation : { required: true }},
        //             email : { 
        //                 validation : { 
        //                     required: true, 
        //                     email : {
        //                         message : 'please use valid email address'
        //                     }, 
        //                     minLength : 2, maxLength : 80 
        //                 }
        //             }
        //         }
        //     });

        //     self.accountHolderText = ko.computed(function() {
        //         return self.accountHolder() ? 'YES' : 'No';
        //     }); 

        //     return self;
        // }

        return function(model){
        var self = this;

        // ----- rigth info
        self.name = ko.observable(model.firstName + ' ' + model.lastName);
        self.address = ko.observable(model.address || "-");
        self.email = ko.observable(model.email);
        // -------------------------



        self.members = ko.observableArray(ko.utils.arrayMap(model.members, function(m){
            return new Member(m);
        }));

        self.relationshipList = ko.observableArray(); //select
        $.get('/api/user/getRelationships', self.relationshipList);//todo: move in model

        self.currentMember = ko.observable(null);


        self.exit = function(){
            vent.trigger('logout');
        }

        
        var cleanCurrentMenber = function(){
            self.currentMember(new Member({
                id : '',
                occupation : '',
                email : '',
                firstName : '',
                lastName : '',
                dateOfBirth : '',

                accountHolder : false
            }));
        }
        cleanCurrentMenber();

        //if current user not exis as member add it data in form
        var current_user_member = ko.utils.arrayFirst(self.members(), function(m){ 
            return  model.firstName == m.firstName() && 
                    model.lastName == m.lastName();
        });
        if (!current_user_member){
             self.currentMember(new Member({
                id : '',
                occupation : model.occupation,
                email : model.email,
                firstName : model.firstName,
                lastName : model.lastName,
                dateOfBirth : model.dateOfBirth,

                accountHolder : true
            }));   
        }

        self.editMember = function(member){
            self.currentMember(member);
        }

        self.deleteMember = function(member){
            core.ajax_post('/api/member/delete', { id : member.id }, function(){
                self.members.remove(member);
                cleanCurrentMenber();
            }).fail(function(){
                alert('can`t delete, exist bank account with this member.')
            });
        }
        self.memberExistError = ko.observable('');

        self.done = function(){
            vent.trigger('update_state', 'register2');
        }

        self.save = function(){
            var duplicated = ko.utils.arrayFirst(self.members(), function(m){ 
                return (self.currentMember().id() != m.id()) && 
                       (self.currentMember().firstName() == m.firstName() && 
                        self.currentMember().lastName() == m.lastName());
            });

            if (duplicated){
                self.memberExistError('member with this name already exist');
                return;
            } else self.memberExistError('');

            //TODO : FIX SERVER!!!
            var relationship = ko.utils.arrayFirst(self.relationshipList(), function(r){ return r.id == self.currentMember().relationship.id(); })
            if (relationship) self.currentMember().relationship.name(relationship.name);
            else     {
                self.currentMember().relationship.name(undefined);

            }
            if (self.currentMember().errors().length != 0){
                self.currentMember().errors.showAllMessages();
                return;
            } 

            var currentMember = ko.toJS(self.currentMember());
            
            var member = {
                id : currentMember.id,
                firstName : currentMember.firstName, 
                lastName : currentMember.lastName,
                email : currentMember.email,
                occupation : currentMember.occupation,
                relationship :  currentMember.relationship,
                accountHolder : currentMember.accountHolder,
                dateOfBirth : currentMember.dateOfBirth
            }
            // member = { relationship : { name : '-' } } - no relation, now it throw exeption
            //FIX SERVER!!!FIX SERVER!!!FIX SERVER!!!FIX SERVER!!!FIX SERVER!!!FIX SERVER!!!
            if (self.currentMember().relationship.name() == undefined)  
                delete member.relationship;          
            
            core.ajax_post('/member/add', member, function(newMember){
                if (currentMember.id == '')
                {
                    self.members.push(new Member(newMember));
                }

                cleanCurrentMenber();
            });
            
        }

        self.template = template;
    }
});
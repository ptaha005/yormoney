define([
    "knockout",
    "jquery",    
    "text!./../templates/Register1.html",
    "core",
    "vent"
    ], function(ko, $,  template, core, vent){
    var validateDate = function(day, month, year, emptyIsValid){
            if (emptyIsValid && day == '' && month == '' && year == ''){ //all empty - date valid -not set
                return false;
            }

            if (day == '' || month == '' || year == '') {
                return true;
            }
            else {
                var d = new Date(parseInt(year, 10), parseInt(month, 10) -1 , parseInt(day, 10));

                return isNaN(d.getTime()) ||
                (d.getDate() != day) ||
                (d.getMonth() +1 != month ) || 
                (d.getFullYear() != year);
            }
        }
 var calculateDate = function(day, month, year){
            if (day == '' && month == '' && year == '') 
                return null;
            else 
                return year + '-' + month + '-' + day;
        }
    return function(){
        var self = this;
        var user = {
            firstName : ko.observable('').extend({ required: true, minLength : 2, maxLength : 30  }),
            lastName : ko.observable('').extend({ required: true , minLength : 2, maxLength : 30 }),
            address1 : ko.observable('').extend({  maxLength : 30 }),
            address2 : ko.observable('').extend({  maxLength : 30 }),
            address3 : ko.observable('').extend({  maxLength : 20 }),
            
            email : ko.observable('').extend({ 
                required: true, 
                email : {
                    message : 'please use valid email address'
                }, 
                minLength : 2, maxLength : 80 }),
            occupation : ko.observable('').extend({ required: true }),
            postcode1 : ko.observable('').extend({ required: true }),
            postcode2 : ko.observable('').extend({ required: true }), //, pattern: /^\d{1,9}$/
           // dateOfBirthday : ko.observable('').extend({ date : true }),
            occupation : ko.observable('').extend({ required: true , minLength : 2, maxLength : 30 }),
            username : ko.observable('').extend({ required: true, minLength : 2, maxLength : 30 }),
            password : ko.observable('').extend({ required: true, minLength : 6, maxLength : 30 })
       ,
            day : ko.observable(''),
            month : ko.observable(''),
            year : ko.observable('')
        }
        user.dateInvalid = ko.computed(function(){
            return validateDate(user.day(), user.month(), user.year(), true);
        });

        self.user = ko.validatedObservable(user);
        self.fistTime = ko.observable(false);//todo : find best solution


        self.code1 = ko.observable('');
        self.code2 = ko.observable('');
        self.code3 = ko.observable('');
        self.code4 = ko.observable('');
        self.agree = ko.observable(false);

        self.activateError = ko.observable('');

        self.exit = function(){
            vent.trigger('logout');
        }

        self.getCode = function(){            
            
            if (self.user.errors().length != 0){
                self.fistTime(true);                
                self.user.errors.showAllMessages()
            } else {            
                var data = ko.toJS(self.user);
                data.address = data.address1 + data.address2 + data.address3;
                
                data.postcode = data.postcode1 + data.postcode2;

                var d = new Date()
                var n = d.getTimezoneOffset();
                data.timezone = n;

                delete data["address1"];
                delete data["address2"];
                delete data["address3"];

                delete data["postcode1"];
                delete data["postcode2"];
                delete data["errors"];


                data.dateOfBirthday = calculateDate(data.day, data.month, data.year);
                delete data["day"];
                delete data["month"];
                delete data["year"];
                delete data["dateInvalid"];

                core.ajax_post('/api/registration/sendActivationCode', data, function(r){
                    if (r.jsonValues.success)
                        alert('Activation code has been sent to ' + self.user().email());           
                    else
                        alert('ERORR : ' + r.jsonValues.message);                   
                });
            }
        }

        self.showTerms = function(){
            vent.trigger('showTerms');
        }

        self.activate = function(){
            if (self.agree() == false) return;

            var code = self.code1() + "-" + self.code2() + "-" + self.code3() + "-" + self.code4();

            core.ajax_post('/api/registration/activate', { activationCode : code }, function(r){
                if (r.jsonValues.success)
                    vent.trigger('update_state', 'register1');           
                else
                    self.activateError(r.jsonValues.message || '');
            });
        }
        self.template = template;
    }
});
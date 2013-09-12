define([
    "knockout",
    "jquery",    
    "text!./../templates/Login.html",
    "core",
    "vent"
    ], function(ko, $,  template, core, vent){

ko.bindingHandlers.executeOnEnter = {
    init: function (element, valueAccessor, allBindingsAccessor, viewModel) {
        var allBindings = allBindingsAccessor();
        $(element).keypress(function (event) {
            var keyCode = (event.which ? event.which : event.keyCode);
            if (keyCode === 13) {
                allBindings.executeOnEnter.call(viewModel);
                return false;
            }
            return true;
        });
    }
};

    return function(){
        var self = this;

        self.password = ko.observable();
        self.userName = ko.observable();

        self.error = ko.observable('');

        self.login = function(){
            var data = {
                password : self.password(),
                username : self.userName()
            };
            core.ajax_post('/api/user/signin', data, function(result){
                if (result.jsonValues.success){
                    vent.trigger('next', result.describeState);
                }
                else
                    self.error(result.jsonValues.message);
            });

        }


        

        self.onRemove = function(){           
            $('body').removeClass('nobackground');
        }

        self.afterRender = function(){
            $('body').addClass('nobackground');
        }

        self.template = template;
    }
});
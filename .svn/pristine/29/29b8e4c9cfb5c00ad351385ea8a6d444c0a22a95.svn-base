define([
    "knockout",
    "jquery",    
    "text!./../templates/Forgot.html",
    "core"
    ], function(ko, $,  template, core){

    return function(model){
        var self = this;
        var isUsername = model.what == 'username';

        self.email = ko.observable('');
        self.error = ko.observable('');
        self.buttonText = isUsername ? "remind username" : "get new password"; 
        self.successText = ko.observable('');
        self.error = ko.observable('');

        self.onRemove = function(){           
            $('body').removeClass('nobackground');
        }

        self.afterRender = function(){          
            $('body').addClass('nobackground');
        }

        self.nothing = function(){
        	return false;
        }

        self.send = function(){
        	if (isUsername){
        		core.ajax_post('/api/user/forgot/username', { email : self.email()  }, function(r){
        			if (r.success)
        				self.successText(r.message);	
        			else
                        self.error(r.message);
        		});
        	} else {
        		core.ajax_post('/api/user/forgot/password', { email : self.email()  }, function(r){
        			if (r.success)
        				self.successText(r.message);	
        			else
        				self.error(r.message);
        		});
        	}
        }

        self.template = template;
    }
});
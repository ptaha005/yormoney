define([
    "knockout",
    "jquery",    
    "text!./../templates/DemoPage.html",
    "vent"
    ], function(ko, $,  template, vent){

    return function(){
        var self = this;

        self.next = function(){
            document.location = '#/home';
        	//vent.trigger('update_state', 'complite');//update_state
        }

        self.exit = function(){
            vent.trigger('logout');
        }
        
        self.template = template;
    }
});
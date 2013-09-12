define([
    "knockout",
    "jquery",    
    "text!./../templates/Guides.html"
    ], function(ko, $,  template){

    return function(model){
        var self = this;

        $.extend(self, model[0]);

        self.afterRender = function(){
            $('#myModal').modal('show');
        }

        self.template = template;
    }
});
define([
    "knockout",
    "jquery",    
    "text!./../templates/Results.html"
    ], function(ko, $,  template){

    return function(){
        var self = this;


        self.template = template;
    }
});
define([
    "knockout",
    "jquery",    
    "text!./../templates/HowToVidio.html"
    ], function(ko, $,  template){

    return function(model){
        var self = this;

        $.extend(self, model[0]);

        self.afterRender = function(){
            $('#myModal').modal('show');
            $('#myModal').on('hide', function(){
                //bug this part of vidio
                $('.video_welcome').remove();
            });
        }


        self.template = template;
    }
});
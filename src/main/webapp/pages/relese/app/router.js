define([ 
    "Sammy" 
    , "knockout"
    , "moduls/application/start" 
   // , "moduls/dashboard/start"
    //, "moduls/registration/start"
    ],function(Sammy, ko, app) {

    return  Sammy(function(){

        //load main modul and lib, all other moduls load by request 
        var dashboard = function(cb){
            return require(['moduls/dashboard/start'], cb);
        } 
        var registration = function(cb){
            return require(['moduls/registration/start'], cb);
        }
        // --------------- dashboard -----------------------
        this.get('#/productInfo/:tab', function(){
            var tabName = this.params['tab'];
            dashboard(function(m){
                m.showTab(tabName);
            });  
        })

        this.get('#/productInfo', function(){
            window.location = '#/productInfo/home';
        })

        this.get('#/productSelect', function(){
            dashboard(function(m){
                m.showProductSelect();
            });
        })

        this.get('#/calendar', function(){
            dashboard(function(m){
                m.showCalendar();
            });
        })

        this.get('#/calendar', function(){
            dashboard(function(m){
                m.showCalendar();
            });
        })

        this.get('#/insurance', function(){
            dashboard(function(m){
                m.showInsurance();
            });
        });

        this.get('#/home', function(){
            dashboard(function(m){
                m.showHome();
            });
        })

        this.get('#/address', function(){
            dashboard(function(m){
                m.showAdressBook();
            });
        })

        this.get('#/tasks', function(){
            dashboard(function(m){
                m.showTaskList();
            });
        })

        this.get('#/tasks/new', function(){
            dashboard(function(m){
                m.showAddTask();
            });
        })

        this.get('#/tasks/:id', function(){
            var id = this.params["id"];
            dashboard(function(m){
                m.showEditTask(id);
            });
        })
        // --------------- registration -----------------------

        this.get('#/welcome', function(){
            registration(function(m){ m.showWelcome()}); 
        })

        this.get('#/registration2', function (req) { 
            registration(function(m){ m.showRegistration2() }); 
        });

        this.get('#/bankaccounts', function (req) {
            registration(function(m){ m.showBankAccounts()});
        });

        this.get('#/income', function (req) { 
            registration(function(m){ m.showIncome()}); 
        });

        this.get('#/expenditure', function (req) {
            registration(function(m){ m.showExpenditure()});
        });

        this.get('#/events/:id', function(){
            registration(function(m){ m.showEvents(this.params["id"])});
        })

        this.get('#/events', function(){
            registration(function(m){ m.showEvents(0)});
        })

        this.get('#/summary', function(){
            registration(function(m){ m.showSummary()});
        });

        this.get('#/complete', function(){
            registration(function(m){ m.showComplete()});    
        })

        // ------------------------------- other

        this.get('#/registration1', function (req) { 
            app.showRegistration(); 
        });

        this.get('#/login', function(){
            app.redirect_to_user_state();    
        })

        this.get('#/forgot/:what', function(){
            app.showForgot(this.params["what"])
        })

        this.get('#/results', function () {
            app.showResult();        
        });

        this.get('#/demo', function(){
            app.showDemoPage();
        })

        this.around(
            app.checke_autorizetion([
                '/#/login', 
                '/#/forgot/username', 
                '/#/forgot/password', 
                '/#/registration1'
            ])
        );

        this.get('', function (req) { 
            this.redirect('#/login');
        });

        this.bind('run', function(){
            ko.applyBindings(app);
        })
    });
});     
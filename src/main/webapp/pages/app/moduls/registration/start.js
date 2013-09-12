define([ 
    "moduls/application/start" ,
    "./viewModels/Welcome",
    "./viewModels/Register2",
    "./viewModels/BankAccounts",
    "./viewModels/Income",
    "./viewModels/Expenditure",
    "./viewModels/Events",
    "./viewModels/Summary",
    "./viewModels/Complete"
],function(
    app,
    Welcome,
    Register2,  
    BankAccounts,
    Income, 
    Expenditure,  
    Events,
    Summary,
    Complete) {
 
    var content = app.content;
 
    var showWelcome = function(){
        content.render(Welcome);
    }

    var showRegistration2 = function(){
        content.render(Register2, '/api/user/getUserInfo');
    }

    var showBankAccounts = function(){
        content.render(app.GridLayout, { title : 'Y&ouml;r - Bank Accounts', fromPage : 'bankaccounts'  });
        content().content.render(BankAccounts, '/api/bankaccount/init');       
    }

    var showIncome = function(){
        content.render(app.GridLayout, { title : 'Y&ouml;r - Income', fromPage : 'income' });
        content().content.render(Income, '/api/income/init')
    }

    var showExpenditure = function(){
        content.render(app.GridLayout, { title : 'Y&ouml;r - Expenditure', fromPage : 'expenditure' });
        content().content.render(Expenditure, '/api/expenditure/init');
    }

    var showEvents = function(id){
        id = id || 0;
        content.render(app.GridLayout, { title : "Y&ouml;r - Events & One-Off's", fromPage : 'events' });
        content().content.render(Events, '/api/event/plainlist/' + id);
    }

    var showSummary = function(){
        content.render(Summary, '/api/expenditure/total');
    }

    var showComplete = function(){
        content.render(Complete);
    }

    return {
        showWelcome : showWelcome,
        showRegistration2 : showRegistration2,
        showBankAccounts : showBankAccounts,
        showIncome : showIncome,
        showExpenditure : showExpenditure,
        showEvents : showEvents,
        showSummary : showSummary,
        showComplete : showComplete
    };
}); 
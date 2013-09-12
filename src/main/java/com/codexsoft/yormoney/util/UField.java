package com.codexsoft.yormoney.util;

import com.codexsoft.yormoney.domain.Bank;
import com.codexsoft.yormoney.domain.BankAccount;
import com.codexsoft.yormoney.domain.Expenditure;
import com.codexsoft.yormoney.domain.Income;
import com.codexsoft.yormoney.services.BankAccountService;
import com.codexsoft.yormoney.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class UField {

    @Autowired
    private static MemberService memberService;

    @Autowired
    private static BankAccountService bankAccountService;

    public static void updateFieldIncome(Income income, String field , String value){
       /* switch (field){
            case "active":
                income.setActive(!income.getActive());
                break;
            case "amount":
                income.setAmount(Integer.parseInt(value));
                break;
            case "frequency":
                income.setFrequency(value);
                break;
            case "incomeSource":
                income.setIncomeSource(value);
                break;
            case "member ":
                income.setMember(memberService.getMemberById(Long.parseLong(value)));
                break;
            case "paidAC":
                income.setPaidAC(value);
                break;
            case "paidDateDay":
                income.setPaidDateDay(Integer.parseInt(value));
                break;
        } */
    }

    public static void updateFieldExpenditure(Expenditure expenditure, String field , String value){
      /*  switch (field){
            case "active":
                expenditure.setActive(!expenditure.getActive());
                break;
            case "cost":
                expenditure.setCost(Integer.parseInt(value));
                break;
            case "frequency":
                expenditure.setFrequency(value);
                break;
            case "companyName":
                expenditure.setCompanyName(value);
                break;
            case "member ":
                expenditure.setMember(memberService.getMemberById(Long.parseLong(value)));
                break;
            case "paidFromAC":
                expenditure.setPaidFromAC(value);
                break;
            case "paidDateDay":
                expenditure.setPaidDateDay(Integer.parseInt(value));
                break;
        }         */
    }

    public static void updateFieldBankAccount(BankAccount bankAccount, String field , String value){
       /* switch (field){
            case "purpose":
                bankAccount.setPurpose(value);
                break;
            case "balance":
                bankAccount.setBalance(Integer.parseInt(value));
                break;
            case "bank":
                Bank bank = bankAccountService.getBankById(Long.parseLong(value));
                bankAccount.setBank(bank);
                break;
            case "member ":
                bankAccount.setMember(memberService.getMemberById(Long.parseLong(value)));
                break;
        }    */

    }
}

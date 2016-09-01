import groovy.mock.interceptor.*

class BankAccountTests extends GroovyTestCase{

    private account

    def void setUp(){
        account  = new BankAccount(10)
    }
    def void tearDown(){
        account = null
    }

    def void testCanDepositMoney(){
        account.deposit(4)
        assert account.balance == 14
    }
    def void testCanWithdrawMoney(){
        account.withdraw(3)
        assert 7 == account.balance
    }
    def void testCanNotWithdrawMoreMoneyThanBalance(){
        shouldFail{
            account.withdraw(15)
        }
    }
    def void testCanAccrueInterest(){

        def service = new MockFor(InterestRateService)
        service.demand.getInterestRate(){
            return 0.10
        }
        service.use{
            account.accrueInterest()
            assert account.balance == 11
        }
    }


}

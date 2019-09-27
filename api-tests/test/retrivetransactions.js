
var common = require("./common");

var request = common.request
var assert = common.assert
describe('Get Transactions List', function() {
    it('200 - Respond with List of transactions for the Account 5678678792', function(done) {
             request.get('accounts/5678678692/transactions')
            .set('Content-Type', 'text/json')
            .send()
              .end((err, res) =>   {
                 if (err) return done(err);
                assert.equal(res.status,200)
                assert.equal(res.body[0].accountNumber,'5678678692');
                assert.equal(res.body[0].accountName,'Savings Account');
                assert.equal(res.body[0].transAmount,9500.45);
                assert.equal(res.body[0].transType,'Credit');
                assert.equal(res.body[0].currCode,'SGD');
                assert.equal(res.body[1].accountNumber,'5678678692');
                assert.equal(res.body[1].accountName,'Savings Account');
                assert.equal(res.body[1].transAmount,8900.45);
                assert.equal(res.body[1].transType,'Debit');
                assert.equal(res.body[1].currCode,'SGD');
               done();
            });
    });

     it('404 - Return Transaction Not Found for invalid account', function(done) {
                request.get('accounts/5678678792/transactions')
                .set('Content-Type', 'text/json')
                .send()
                  .end((err, res) =>   {
                     if (err) return done(err);
                    assert.equal(res.status,404)
                    assert.equal(res.body.message,'No transactions for the account')
                   done();
                });
        });
});
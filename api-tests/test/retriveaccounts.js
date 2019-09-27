var common = require("./common");

var request = common.request
var assert = common.assert

describe('Get Accounts Test', function() {
    it('200 - Respond with List of Accounts for the Customer 10000000', function(done) {
            request.get('customers/10000000/accounts')
            .set('Content-Type', 'text/json')
            .send()
              .end((err, res) =>   {
                 if (err) return done(err);
                assert.equal(res.status,200)
                assert.equal(res.body[0].accountNumber,'5678678692');
                assert.equal(res.body[0].accountName,'SGSavings78');
                assert.equal(res.body[0].availBalance,84899.23);
                assert.equal(res.body[1].accountNumber,'6786786923');
                assert.equal(res.body[1].accountName,'AUSavings90');
                assert.equal(res.body[1].availBalance,88005.23);
               done();
            });
    });

     it('404 - Return Account Not Found for invalid customer', function(done) {
                request.get('customers/22323/accounts')
                .set('Content-Type', 'text/json')
                .send()
                  .end((err, res) =>   {
                     if (err) return done(err);
                    assert.equal(res.status,404)
                    assert.equal(res.body.message,'No accounts for the customer')
                   done();
                });
        });
});
'use strict';

require('chai').should();

import asset from '../asset';

describe('User Assets', function() {
    xit('should be able to get user assets', function(done) {
        asset.getUserAssets('uid').then(function(data){
            data.body.length.should.be.above(0);
            data.body[0].assetName.should.be.equal('MacBook1');
            data.body[0].assetNumber.should.be.equal('200100357');
            data.body[0].assignedDate.should.be.equal('2015-05-07');
            data.body[0].assetType.should.be.equal('MAC');
            done();
        }).catch(function(err){
            console.log(err);
            done(err);
        });
    });
    it('should be able to add an asset', function(done){
        asset.addAsset({
            type:"Apple Laptop",
            number:"12345678"
        }).then(function(data){
            data.type.should.be("Apple Laptop");
            data.statusCode.should .be.equal(201);
            done();
        }).catch(function(err){
            done();
        });
    });
    it('should not be able to add an asset when number is not 8 figures', function(done){
        asset.addAsset({
            type:"Apple Laptop",
            number:"12345"
        }).then(null, function(err){
            err.errorMessage.should.be.equal('The length of number must be 8!');
            err.statusCode.should.be.equal(409);
            done()
        }).catch(function(err){
            done(err)
        });
    });
    xit('should be able to get others assets', function(done) {
        asset.getOthersAssets().then(function(data) {
            var assets = data.body;
            assets.length.should.be.above(0);
            assets[0].account.should.be.equal('twer');
            assets[0].assetName.should.be.equal('MacBook1');
            assets[0].assetNumber.should.be.equal('200100357');
            assets[0].assignedDate.should.be.equal('2015-05-07');
            assets[0].assetType.should.be.equal('MAC');
            done();
        }).catch(function(err) {
            console.log(err);
            done(err);
        });
    });
});

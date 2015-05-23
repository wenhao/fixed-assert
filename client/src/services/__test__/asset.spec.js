'use strict';

require('chai').should();

import asset from '../asset';

describe('User Assets', function() {
    it('should be able to get user assets', function(done) {
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

    it('should be able to get others assets', function(done) {
        asset.getOthersAssets().then(function(data) {
            var assets = data.body;
            assets.length.should.be.above(0);
            assets[0].ownerName.should.be.equal('twer');
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

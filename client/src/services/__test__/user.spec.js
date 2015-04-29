'use strict';

require('chai').should()

import user from '../user'

describe('User Services', function () {
    it('should be able to login', function (done) {
        user.login()
            .then(function (data) {
                data.should.be.equal('success')
                done()
            })
            .catch(function (err) {
                done(err)
            })
    });
    it('should be able to get his assets', function (done) {
        user.assets('sqlin').then(function (assets) {
            assets.should.be.an.Object;
            assets.data.should.be.an.Array;
            assets.data.length.should.be.above(1);
            assets.data[0].assetName.should.be.equal('Mac Book 15 inch');
            assets.data[0].assetNumber.should.be.equal('201400356');
            assets.data[0].assetType.should.be.equal('MAC');
            assets.data[0].ownerName.should.be.equal('Waterstrong');

            done();
        })
            .catch(function (err) {
                done(err);
            })
    })
});

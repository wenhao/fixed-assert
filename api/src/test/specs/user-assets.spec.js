'use strict';

var request = require('request-promised'),
    httpStatus = require('http-status-codes'),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

describe("User Asset API tests", function() {
    it("should get user assets", function(done) {
        request.get(config.host + "/asset/sqlin/list", {json: true})
            .then(function(res) {
                expect(res.statusCode).toBe(httpStatus.OK);

                //res.should.be.Object;
                //expect(res.body).toEqual([{
                //    "assetName":"Mac Book 15 inch",
                //    "assetNumber":"201400356",
                //    "assetType":"MAC",
                //    "assignDate":1429891200000,
                //    "ownerName":"Waterstrong"}
                //]) ;

                done();
            }).catch(utils.printErr);
    });
});
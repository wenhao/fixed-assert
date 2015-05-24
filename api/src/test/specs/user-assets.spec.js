'use strict';

var request = require('request-promised'),
    httpStatus = require('http-status-codes'),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

describe("User Assets API tests", function () {

    it("should get others users assets", function (done) {
        request.get(config.host + "/users/lwzhang/others/assets", {json: true}).
            then(function (res) {
                expect(res.statusCode).toBe(httpStatus.OK);
                var assets = res.body;
                expect(assets.length).toBe(11);
                expect(assets[0].account).toBe("admin");
                expect(assets[0].assetName).toBe("All assets");
                expect(assets[0].assetNumber).toBe("17000000");
                expect(assets[0].assignedDate).toBe("2015-04-05");
                expect(assets[0].assetType).toBe("All");
                expect(assets[1].account).toBe("cylin");
                expect(assets[1].assetName).toBe("MacBook Air");
                expect(assets[1].assetNumber).toBe("17000003");
                expect(assets[1].assignedDate).toBe("2015-04-06");
                expect(assets[1].assetType).toBe("Laptop");
                done();
            }).catch(utils.printErr);
    });

    it("-> should get specific user assets", function (done) {
        request.get(config.host + "/users/lwzhang/assets", {json: true})
            .then(function (res) {
                expect(res.statusCode).toBe(httpStatus.OK);
                expect(res.body.length).toBe(2);
                expect(res.body[0].assetName).toBe("MacBook Pro");
                expect(res.body[0].assetNumber).toBe("17000001");
                expect(res.body[0].assignedDate).toBe("2015-04-05");
                expect(res.body[0].assetType).toBe("Laptop");
                expect(res.body[1].assetName).toBe("iPhone5S");
                expect(res.body[1].assetNumber).toBe("17000002");
                expect(res.body[1].assignedDate).toBe("2015-04-05");
                expect(res.body[1].assetType).toBe("Mobile");
                done();
            }).catch(utils.printErr);
    });
});
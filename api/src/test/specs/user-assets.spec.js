'use strict';

var request = require('request-promised'),
    httpStatus = require('http-status-codes'),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

describe("User Assets API tests", function () {

    xit("should get others users assets", function (done) {
        request.get(config.host + "/asset/others", {json: true}).
            then(function (res) {
                expect(res.statusCode).toBe(httpStatus.OK);
                var assets = res.body;
                expect(assets[0].ownerName).toBe("twer");
                expect(assets[0].assetName).toBe("Macbook");
                expect(assets[0].assetNumber).toBe("123456");
                expect(assets[0].assignedDate).toBe("2015-05-08");
                expect(assets[0].assetType).toBe("Laptop");
                expect(assets[1].ownerName).toBe("shuiqiang");
                expect(assets[1].assetName).toBe("iPhone");
                expect(assets[1].assetNumber).toBe("123457");
                expect(assets[1].assignedDate).toBe("2015-05-09");
                expect(assets[1].assetType).toBe("Mobile");
                done();
            }).catch(utils.printErr);
    });

    xit("-> should get specific user assets", function (done) {
        request.get(config.host + "/asset/2", {json: true})
            .then(function (res) {
                expect(res.statusCode).toBe(httpStatus.OK);
                expect(res.body[0].assetName).toBe("MacBook Pro");
                expect(res.body[0].assetNumber).toBe("170170170");
                expect(res.body[0].assignedDate).toBe("2015-04-05");
                expect(res.body[0].assetType).toBe("Laptop");
                expect(res.body[1].assetName).toBe("iPhone5S");
                expect(res.body[1].assetNumber).toBe("180170170");
                expect(res.body[1].assignedDate).toBe("2015-04-05");
                expect(res.body[1].assetType).toBe("Mobile");
                done();
            }).catch(utils.printErr);
    });
});
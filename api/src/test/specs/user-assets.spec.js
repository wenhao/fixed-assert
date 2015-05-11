'use strict';

var request = require('request-promised'),
    httpStatus = require('http-status-codes'),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

describe("User Assets API tests", function () {
    it("should get user assets", function (done) {
        request.get(config.host + "/users/uid/assets", {json: true})
            .then(function (res) {
                expect(res.statusCode).toBe(httpStatus.OK);
                expect(res.body[0].assetName).toBe("Macbook");
                expect(res.body[0].assetNumber).toBe("123456");
                expect(res.body[0].assignedDate).toBe("2015-05-08");
                expect(res.body[0].assetType).toBe("Laptop");
                expect(res.body[1].assetName).toBe("iPhone");
                expect(res.body[1].assetNumber).toBe("123457");
                expect(res.body[1].assignedDate).toBe("2015-05-09");
                expect(res.body[1].assetType).toBe("Mobile");
                done();
            }).catch(utils.printErr);
    });
});
'use strict';

var request = require("request-promised"),
    HttpStatus = require("http-status-codes"),
    config = require("../config/default.conf.js"),
    utils = require("../common/utils");

  describe("create assets api tests", function () {
    xit("should create  assets success", function (done) {
        request.post({
            uri: config.host + "/asset",
            json: {assetType: "Apple Laptop", assetName: "17001176"}
        }).then(function (res) {
            expect(res.statusCode).toBe(201)
            done();
        }).catch(utils.printErr);
    });

      xit("should get bad request code and error message " +
          "when asset name be null", function (done) {
          request.post({
              uri: config.host + "/asset",
              json: {assetType: "Apple Laptop"}
          }).then(function (res) {
              expect(res.statusCode).toBe(400)
              expect(res.body.errorMessage).toBe("Name should not be null.")
              expect(res.body.errorCode).toBe("INVALID_ASSET_NAME")
              done();
          }).catch(utils.printErr);
      });

      xit("should get bad request code and error message " +
          "when asset name not be made up of 8 numbers.", function (done) {
          request.post({
              uri: config.host + "/asset",
              json: {assetType: "Apple Laptop",assetName: "123abc"}
          }).then(function (res) {
              expect(res.statusCode).toBe(400)
              expect(res.body.errorMessage).toBe("Name should be made up of 8 numbers.")
              expect(res.body.errorCode).toBe("INVALID_ASSET_NAME")
              done();
          }).catch(utils.printErr);
      });
});

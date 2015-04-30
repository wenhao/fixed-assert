'use strict';

export default [
    {
        pattern: 'http://localhost:8080/asset/(sqlin)/list',
        // callback that returns the data
        fixtures: function () {
            return {
                body: [{
                    "assetName":"Mac Book 15 inch",
                    "assetNumber":"201400357",
                    "assetType":"MAC",
                    "assignDate":1429891200000,
                    "ownerName":"Waterstrong"
                }, {
                    "assetName":"Mac Book 13.5 inch",
                    "assetNumber":"201500356",
                    "assetType":"MAC",
                    "assignDate":1429891200000,
                    "ownerName":"Shuiqiang Lin"}
                ]
            };
        },
        // `match`: result of the resolution of the regular expression
        // `data`: data returns by `fixtures` attribute
        callback: function (match, data) {
            if (match[1]) {
                return data
            } else {
                return new Error('Do not match any urls!')
            }
        }
    }
];

'use strict';

export default [
    {
        pattern: 'http://localhost:8080/users/(uid)/assets',
        // callback that returns the data
        fixtures: function () {
            return {
                body: [{
                    "assetName":"MacBook1",
                    "assetNumber":"200100357",
                    "assignedDate":"2015-05-07",
                    "assetType":"MAC"
                }, {
                    "assetName": "MacBook2",
                    "assetNumber": "200100356",
                    "assignedDate": "2015-3-4",
                    "assetType": "MAC"
                }]
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

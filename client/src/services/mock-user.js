export default [
  {
    pattern: 'http://localhost:8080/user/(login|logout)',
    // callback that returns the data
    fixtures: function () {
      return 'success'
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
  },{
    pattern: 'http://localhost:8080/user/(assets)',
    // callback that returns the data
    fixtures: function () {
      return {
        data: [
          {
            name: 'Zac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: '1ac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Aac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Bac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Dac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'cac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Eac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Fac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Gac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Hac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Iac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Jac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          },{
            name: 'Kac Book',
            number: '1',
            date: '2015-4-25',
            type: 'laptop'
          }
		]
      }
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

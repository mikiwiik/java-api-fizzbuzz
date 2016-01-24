(function () {
    'use strict';

    angular.module('fizzbuzz', [])
        .controller('RestCtrl', RestCtrl);

    function RestCtrl($http, $log, $scope) {
        var vm = this;
        vm.tests = [ ];
        vm.testNumber = function () {
            var numberToTest = $scope.number;
            $log.debug("About to test " + numberToTest);
            $http({
                method: 'GET',
                url: '/api/' + numberToTest
            }).then(function (response) {
                $log.debug("Handling result " + JSON.stringify(response));
                var testResult = {
                    number: numberToTest,
                    result: response.data
                };
                vm.tests.push(testResult);
            });
        };
    }

})();
(function () {
    'use strict';

    angular.module('fizzbuzz-tester', [])
        .controller('RestCtrl', RestCtrl);

    function RestCtrl($http, $log, $scope) {
        var vm = this;
        vm.tests = [ ];
        vm.testNumber = function (numberToTest) {
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
                // Clear the form
                vm.number = null;
                $scope.testerForm.$setPristine(true);
            });
        };
    }

})();
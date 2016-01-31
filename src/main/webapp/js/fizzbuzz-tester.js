(function () {
    'use strict';

    angular.module('fizzbuzz', [])
        .controller('RestCtrl', RestCtrl)
        .controller('StompCtrl', StompCtrl);

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

    function StompCtrl($log, $scope) {
        var vm = this;
        vm.tests = [ ];

        vm.connect = function () {
            var socket = new SockJS('/stomp');
            var stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                $log.debug('Opening SockJS connection: ' + frame);
                stompClient.subscribe('/numbers/new', function (response) {
                    $log.debug("Received number: " + JSON.stringify(response));
                    $scope.$apply(function () {
                        var body = JSON.parse(response.body);
                        vm.tests.push({
                            number: body.number,
                            result: body.fizzBuzz
                        });
                    });
                });
            });
        };

        vm.connect();
    }

})();
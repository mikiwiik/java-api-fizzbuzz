(function () {
    'use strict';

    angular.module('fizzbuzz-results', [])
        .controller('StompCtrl', StompCtrl);

    function StompCtrl($log, $scope) {
        var vm = this;
        vm.tests = [ ];

        var addResult = function (number, fizzBuzz) {
            vm.tests.push({
                number: number,
                result: fizzBuzz
            });
        };

        vm.connect = function () {
            var socket = new SockJS('/stomp');
            var stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                $log.debug('Opening SockJS connection: ' + frame);
                stompClient.subscribe('/numbers/new', function (response) {
                    $log.debug("Received number: " + JSON.stringify(response));
                    $scope.$apply(function () {
                        var body = JSON.parse(response.body);
                        addResult(body.number, body.fizzBuzz);
                    });
                });
            });
        };

        vm.connect();
    }

})();
'use strict';

describe('latestResults directive', function () {

    var $scope, $compile;

    beforeEach(module('fizzbuzz-results.directives', function ($provide, $controllerProvider) {
            // Mock StompCtrl
            $controllerProvider.register('StompCtrl', function ($scope) {
                return {}
            });
        })
    );

    beforeEach(inject(function (_$compile_, _$rootScope_) {
        $compile = _$compile_;
        $scope = _$rootScope_.$new();
    }));

    it('Should use the value of data-results-heading as the heading', function () {
        var heading = 'Latest results';
        var element = $compile(
                '<data-latest-results data-results-heading="' + heading + '"></data-latest-results>')($scope);
        $scope.$digest();

        expect($(element).find('#results-heading')).toContainText(heading);
    });
});

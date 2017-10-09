app.controller('RoomCtrl', function ($scope, RoomService) {
    $scope.input_data = '';

    $scope.elem_num = 0;
    $scope.sum = 0;
    $scope.sumsq = 0;
    $scope.avg = 0;
    $scope.standard_deviation = 0;


    $scope.caculateStandardDeviation = function () {
        alert('haha');
        var elems = $scope.elem_num.split(';');
        $scope.elem_num = elems.length;
        for (var i = 0; i < elems.length; i++) {
            var elem_int = elems[i] * 1;
            $scope.sum += elem_int;
            $scope.sumsq += elem_int * elem_int;
        }

        $scope.avg = $scope.sum / $scope.elem_num;
    }
}
);

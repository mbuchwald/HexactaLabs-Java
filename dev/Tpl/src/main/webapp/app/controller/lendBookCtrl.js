booksApp.controller('lendBookCtrl', function ($scope, $location, $rootScope, $routeParams, $http) {
	
	$scope.books = $rootScope.books;
	$scope.bookId = $routeParams.bookId;
	var bookId = $scope.bookId;
	$scope.book = null;
	$scope.copyCode = null;
	
	$scope.backToHome = function(){
    	$location.path("/");
    };
   
    $scope.loadUsers = function(){
		$http({
			method : 'GET',
			url: '/Tpl/rest/users',
			headers : {'Content-type' : 'application/json', 'Accept' : 'application/json'}
		}).success(function(data, status, headers, config){
			if(status == 200)
			{
				$rootScope.users = [];
				$rootScope.users = data;
				$scope.users = $rootScope.users;
			}
		}).error(function(data, status, headers, config){
			console.log("An Error occurred while trying to get all users");
		});
	}
	$scope.loadUsers();
	
	$scope.loadBook = function(){
		$http({
			method : 'GET',
			url : '/Tpl/rest/books/' + bookId,
			headers : {
				'Content-type' : 'application/json',
				'Accept' : 'application/json'
			}
		}).success(function(data, status, headers, config) {
			if (status == 200) {
				$scope.currentBook = data;
				$scope.copyCode = $scope.currentBook.freeBookCopy;
			}
		}).error(function(data, status, headers, config){
			console.log("An Error occurred while trying to get book:" + $scope.bookId);
		});
	}
	$scope.loadBook();
	
	$scope.loadFreeCopy = function(){
		$http({
			method: 'GET',
			url : '/Tpl/rest/copies/book/' + bookId,
			headers : {'Content-type' : 'application/json', 'Accept' : 'application/json'}
		}).success(function(data, status, headers, config){
			if (status == 200){
				$scope.freeCopy = data;
			}
		}).error(function(data, status, headers, config){
			console.log("An error ocurred while trying to get free copy from book: " + bookId);
		});
	}
	$scope.loadFreeCopy();
	

});

var DatepickerDemoCtrl = function ($scope) {
	$scope.today = function() {
    $scope.fromDt = new Date();
  };
  $scope.today();

  $scope.clear = function () {
    $scope.fromDt = null;
    $scope.untilDt = null;
  };

  $scope.openFrom = function($event) {
    $event.preventDefault();
    $event.stopPropagation();
    $scope.openedFrom = true;
  };

  $scope.openUntil = function($event) {
    $event.preventDefault();
    $event.stopPropagation();
    $scope.openedUntil = true;
  };

  $scope.dateOptions = {
    formatYear: 'yy',
    startingDay: 1
  };

  $scope.initDate = new Date('2016-15-20');
  $scope.formats = ['dd MMMM yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
  $scope.format = $scope.formats[0];
};

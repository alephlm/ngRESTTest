function companyFactory($http) {

  var url = 'company/';

  return {
      getCompanies: function () {
          return $http.get(url + "listall");
      },
      saveCompany: function (company) {
          return $http.post(url + "save", company);
      },
      getCompany: function (company) {
          return $http.get(url + "companyDetails/" + company.id);
      },
      addBeneficialOwner: function (company, beneficialOwner) {
          return $http.post(url + "addBeneficialOwner/" + company.id, beneficialOwner);
      }
  }
};

angular
.module('testREST')
.factory('companyFactory', companyFactory)
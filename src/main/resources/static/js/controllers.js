function CompanyController(companyFactory) {
	var self = this;

	self.allCompanies = [];
	self.company = {};
	self.showCompanyForm = false;

	function getAllCompaniesSuccessCallBack(data) {
		self.allCompanies = data;
	}
	
	function addBeneficialOwnerSuccessCallBack(data) {
		self.allCompanies[(self.allCompanies.indexOf(self.company))] = data;
		self.company = data;
		self.owner = {};
	}
	
	function saveCompanySuccessCallBack() {
		self.getAllCompanies();
		self.company = false;
		self.showCompanyForm = false;
	}

	self.getAllCompanies = function() {
		companyFactory.getCompanies().success(getAllCompaniesSuccessCallBack);
	}
	
	self.loadCompanyDetails = function(company) {
		self.company = company;
	}
	
	self.addBeneficialOwner = function(owner) {
		companyFactory.addBeneficialOwner(self.company, owner).success(addBeneficialOwnerSuccessCallBack);
	}
	
	self.addNewCompany = function() {
		self.showCompanyForm = true;
		self.company = {};
	}
	
	self.cancelEdit = function() {
		self.showCompanyForm = false;
		self.company = false;
	}
	
	self.editCompany = function(company) {
		self.showCompanyForm = true;
		self.company = company;
	}
	
	self.saveCompany = function(company) {
		companyFactory.saveCompany(company).success(saveCompanySuccessCallBack);
	}

	self.isEmpty = function(testObj) {
		return testObj === {};
	}
}

angular.module('testREST')
.controller('CompanyController', CompanyController)
import { TestBed, inject } from '@angular/core/testing';

import { DisplayListEmployeesService } from './display-list-employees.service';

describe('DisplayListEmployeesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DisplayListEmployeesService]
    });
  });

  it('should be created', inject([DisplayListEmployeesService], (service: DisplayListEmployeesService) => {
    expect(service).toBeTruthy();
  }));
});

import { TestBed } from '@angular/core/testing';

import { UserRegisterationServiceService } from './user-registeration-service.service';

describe('UserRegisterationServiceService', () => {
  let service: UserRegisterationServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserRegisterationServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

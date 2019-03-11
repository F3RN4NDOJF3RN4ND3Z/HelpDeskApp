import { TestBed } from '@angular/core/testing';

import { UserServiciceService } from './user-servicice.service';

describe('UserServiciceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserServiciceService = TestBed.get(UserServiciceService);
    expect(service).toBeTruthy();
  });
});

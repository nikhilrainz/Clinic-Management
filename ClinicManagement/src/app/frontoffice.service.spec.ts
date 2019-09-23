import { TestBed } from '@angular/core/testing';

import { FrontofficeService } from './frontoffice.service';

describe('FrontofficeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FrontofficeService = TestBed.get(FrontofficeService);
    expect(service).toBeTruthy();
  });
});

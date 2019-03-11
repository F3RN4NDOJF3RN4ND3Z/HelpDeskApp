import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketcommentsComponent } from './ticketcomments.component';

describe('TicketcommentsComponent', () => {
  let component: TicketcommentsComponent;
  let fixture: ComponentFixture<TicketcommentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TicketcommentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketcommentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { Component, OnInit } from '@angular/core';

@Component({
  selector:  'app-root',
  template: `
    <nav class="navbar">

      <!-- logo -->
      <div class="navbar-brand">
        <a class="navbar-item">
          <img src="assets/imges.jpg">
        </a>
      </div>
    </nav>
  `,
 
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

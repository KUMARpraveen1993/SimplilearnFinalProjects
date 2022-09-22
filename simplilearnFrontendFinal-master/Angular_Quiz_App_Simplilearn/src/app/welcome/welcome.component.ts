import { Component, OnInit,ViewChild,ElementRef } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent implements OnInit {

  @ViewChild('name' )nameKey!: ElementRef;
  constructor() { }

  ngOnInit(): void {
  }
  // this method for name box 
  startQuiz(){
    localStorage.setItem("name",this.nameKey.nativeElement.value);
  }

}

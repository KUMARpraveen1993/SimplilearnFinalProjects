import { QuestionService } from './../service/question.service';
import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.scss']
})
export class QuestionComponent implements OnInit {
  //declear variable name

  public name: String = "";

  public currentQuestion: number = 0;
  public questionList: any = [];
  public points: number = 0;
  counter = 60;
  correctAnswer: number = 0;
  incorrectAnswer: number = 0;
  //$ this $ for oveserveval and this property for time.
  interval$: any;
  progress:string="0";

  //if quiz is complete then this property will use.
  isQuizCompleted : boolean=false;

  //constracor helps as to inject our services

  constructor(private QuestionService: QuestionService) { }

  ngOnInit(): void {

    //storing name welcome page box 
    this.name = localStorage.getItem("name")!;
    this.getAllQuestion();
    this.startCounter();

  }
  //To get all question

  getAllQuestion() {
    this.QuestionService.getQuestionJson()
      .subscribe(res => {
        this.questionList = res.questions;
      })

  }

  //next button
  nextQuestion() {
    this.currentQuestion++;
  }
  previousQuestion() {
    this.currentQuestion--;
  }
  //this method for chossing current answer and redirect to next Question.s
  answer(currentQun: number, option: any) {  
    //this lines for if all question will end then result will show.
    if(currentQun===this.questionList.length){
     this.isQuizCompleted = true;
     this.stopCounter();
    }
    if (option.correct) {
      this.points += 10;
      this.correctAnswer++;

      //this is beasause Angular is to fast so we have to slow the question chamge.
setTimeout(()=> {
  this.currentQuestion++;
  this.resetCounter();
  this.getProgressPresent();

    },1000);

    } else {

      setTimeout(() => {
        this.currentQuestion++;
        this.incorrectAnswer++;
        this.resetCounter();
        this.getProgressPresent();
      }, 1000);
     
      this.points -= 10;
      
     

      
    }


  }

  startCounter() {
    this.interval$ = interval(1000).
      subscribe(val => {
        this.counter--;
        if (this.counter === 0) {
          this.currentQuestion++;
          this.counter = 60;
          this.points -= 10;
        }
      });
    //this is for total time interval.
    setTimeout(() => {
      this.interval$.unsubscribe();
    }, 600000);

  }
  
  stopCounter() {
    this.interval$.unsubscribe();
    this.counter = 0;




  }
  resetCounter() {
    this.stopCounter();
    this.counter = 60;
    this.startCounter();



  }
  restQuiz() {
    this.resetCounter();
    this.getAllQuestion();
    this.points = 0;
    this.counter = 60;
    this.currentQuestion=0;
    this.progress="0";
  }
getProgressPresent(){
this.progress= ((this.currentQuestion/this.questionList.length)*100).toString();
return this.progress;

}

}

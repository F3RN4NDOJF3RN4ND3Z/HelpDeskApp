export class Comment {
    
    user_id: number;
    comment: String;
    added_date: Date;
    constructor(user_id:number, comment:String) {
        this.added_date=new Date();
        this.user_id=user_id;
        this.comment=comment;
    }
}
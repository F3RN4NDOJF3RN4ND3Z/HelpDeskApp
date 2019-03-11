import {Comment} from "./comments";
export class Ticket {
    
    id: number;
    description: string;
    created_date: Date;
    status: Ticket.status;
    closed_by: number;
    closed_date: Date;
    createdby_id: number;
    organization_id: number;
    category_id:Ticket.category;
    comments: Comment[];
    constructor(description :string, created_by: number,organization_id:number,category:number) {
        this.description=description;
        this.createdby_id=created_by;
        this.organization_id=organization_id;
        this.category_id=category;
        this.created_date=new Date();
        this.status=Ticket.status.OPEN;
        
    }


}

export namespace Ticket
{
    export enum status{
        OPEN,CLOSED
    }

    export enum category{
        GENERAL,IMPORTANT,CRITICAL
    }

}

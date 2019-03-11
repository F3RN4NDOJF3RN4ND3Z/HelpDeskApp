export class User {
        organization_id:Number;
        privileges: User.roles;
        id: Number;
        name: String;
    constructor(name: String, organizarion_id:number,privileges: number) {
        this.name=name;
        this.organization_id=organizarion_id;
        this.privileges=privileges;
        
    }

    
}

export namespace User {
    export enum roles {
        ADMIN,STANDARD
    }
}




export interface JOB{
    active: boolean,
    ctc: string, 
    id: number, 
    description:  string, 
    isActive: boolean, 
    vacancies:  number, 
    filled: number, 
    position: string, 
    bond: boolean, 
    bond_years: number, 
    applied_to_id:  number, 
    interviewer_id: number
  }

  export interface USER{

    credential: CREDENTIAL
    admin: boolean
    qualification:string 
    id: number
    name: string
    email: string
    dob: Date
    experience: number
    applied_to_id : number
    status_id: number
    isAdmin: boolean
    }
    
    export interface CREDENTIAL{
      id: number
      password: string
    }
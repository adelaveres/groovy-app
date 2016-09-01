def enum DAYS {MON, TUE, WED, THU, FRI, SAT, SUN}
def weekdays = DAYS.MON..DAYS.FRI


for(day in weekdays){
    println day
}
println weekdays.from
println weekdays.to



def numbers = 0..9
for(num in numbers){
    if(isEven(num)) {
        println num
    }
}

def isEven(num){
    num%2 == 0
}

//Closures

(1..10).findAll({ return it%2 ==0 }).each({ println "In a closure: $it" })
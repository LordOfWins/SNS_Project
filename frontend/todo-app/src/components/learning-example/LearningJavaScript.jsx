const person = {
    name: 'Max',
    address: {
        street: '10th Street',
        city: 'New York',
        country: 'USA',
    },
    age: 28,
    profile: ['twitter', 'github'],
    printProfile: () => {
        person.profile.map((item) => console.log(item))
    }
}


export default function LearningJavaScript() {
    return (
        <>
            <div>{person.name}</div>
            <div>{person.age}</div>
            <div>{person.address.street}</div>
            <div>{person.profile[1]}</div>
            <div>{person.printProfile()}</div>
        </>
    )
}
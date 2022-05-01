# Bug as a Service

Bug as a Service (BaaS) is a new, innovative service that allows your organization to save time and money on the development process by reducing the debugging effort. 

Many recent studies highlighted how developers spend most of their time on bug fixing. In turn, this translates into missed deadlines, unimplemented features, and a lesser employee engagement ROI. BaaS focuses on solving these problems once and for all.

## How it works

The concept is simple.

Traditionally, developers would hard-code bugs in your codebase and then use legacy tools like continuous integration, unit tests and SonarQube to find them. Then, they need extra time to fix them and refactor the code.

With BaaS, developers instead rely on our external REST API to fetch bugs on-demand. You always have complete control of your codebase through our dashboard, where you can manage all the bugs and disable them by simply clicking on a button.

## API Documentation

### Public API
Base URL: https://bug-as-a-service.herokuapp.com/api/v1

#### Get a list of supported programming languages
    GET /exceptions
    
#### Get a list of supported exceptions for a specific language
    GET /exceptions/<language>
    
#### Get a specific bug for a given language
    GET /exceptions/<language>/<exception_name>

### Private API
Please contact our sales department to get your private API key with access to your management dashboard.

## Customer Success Stories

> When I first heard of "Bug as a Service" I thought it was a joke. We had a .Then their representative asked me a simple question: "If QA is so useful, why do you have bugs in the first place?". We're never going back 

\- John Adams, Head of Development at Vermixion LTD

> The cloud is the future. We should externalize as many services as possible in order to have a better grasp on what we are building

\- Helen Kerrer, CTO at BrownBear
 
> My boss asked me an estimate about solving a terrible bug that made money randomly disappear from our users bank accounts. He was astonished when I told him that I could fix it in five minutes. Then I just went on the dashboard and disabled it. Needless to say, this earned me a promotion. Thanks Bug as a Service!

\- Leo Washabout, Senior Developer at ReliableBank

> It's 2022 and we still have developers handling null values unsafely? Of course there's only one right way to do it: Bug as a Service. That's considered a best practice
 
\- Armando Rossi, Tech Lead at WeSell.com

> Our payment system was so broken, it wouldn't even let us purchase BaaS! If only we bought a subscription earlier...

\- Danilo P., former startup founder, currently in hiding from debt collectors

#### Do you have a story to share? Get in touch with us!

# Senior Angular Developer Interview Preparation Guide

I'll structure this similarly to the Java guide, with interview-ready answers, practical Angular code examples, real-world scenarios, architecture questions, performance optimization and a revision checklist.

This guide covers Angular 14–20 concepts, including modern Angular features such as Signals, standalone components, control flow and deferred loading, while also covering RxJS and traditional Angular architecture.

Writing

# Senior Angular Developer Interview Preparation Guide

## Complete Questions and Answers – Senior Frontend Engineer

**Topics:** Angular, TypeScript, JavaScript, RxJS, Signals, Components, Change Detection, Dependency Injection, Routing, Forms, HTTP, Performance Optimization, Security, Testing and Architecture.

---

# PART 1: TOP 20 SENIOR ANGULAR INTERVIEW QUESTIONS

## 1\. Explain Angular architecture.

**Answer:**

Angular is a TypeScript-based frontend framework used to build single-page applications.

Its architecture consists of:

1. Components – Control UI and application behavior.
2. Templates – Define HTML structure.
3. Services – Implement reusable business logic.
4. Dependency Injection – Manages dependencies.
5. Modules – Organize applications in module-based architecture.
6. Routing – Handles navigation.
7. Directives – Modify DOM behavior.
8. Pipes – Transform displayed values.
9. RxJS – Handles asynchronous data streams.

Typical architecture:

text

```text
Angular Application
       |
       v
    Routing
       |
       v
    Component
       |
       v
    Service
       |
       v
    HttpClient
       |
       v
    Backend REST API
```

Modern Angular also supports standalone components, allowing applications to be organized without NgModules.

---

## 2\. What is the difference between Angular and AngularJS?

**Answer:**

| AngularJS | Angular |
| --- | --- |
| JavaScript-based | TypeScript-based |
| Controller-based architecture | Component-based architecture |
| Uses $scope | Uses component classes |
| Two-way binding is common | Supports one-way and two-way binding |
| Digest cycle | Modern change detection |
| Less optimized for modern applications | Supports modern rendering and optimization |
| AngularJS 1.x | Angular 2+ |

Angular is a complete redesign, not simply a newer version of AngularJS.

---

## 3\. What is the difference between a component and a directive?

**Answer:**

A component is a directive with its own template.

A directive changes the behavior or appearance of existing DOM elements.

**Component example:**

typescript

```typescript
@Component({
  selector: 'app-user',
  template: '<h2>User Profile</h2>'
})
export class UserComponent {}
```

**Attribute directive example:**

typescript

```typescript
@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {

  constructor(
    private el: ElementRef
  ) {
    this.el.nativeElement.style.backgroundColor =
      'yellow';
  }
}
```

**Types of directives:**

1. Component directives.
2. Attribute directives.
3. Structural directives.

Modern Angular also provides built-in control flow such as `@if` and `@for`.

---

## 4\. Explain Angular component lifecycle hooks.

**Answer:**

Angular provides lifecycle hooks to execute logic during a component's lifecycle.

| Lifecycle hook | Purpose |
| --- | --- |
| ngOnChanges | Input properties change |
| ngOnInit | Component initialization |
| ngDoCheck | Custom change detection |
| ngAfterContentInit | Projected content initialized |
| ngAfterContentChecked | Projected content checked |
| ngAfterViewInit | Component view initialized |
| ngAfterViewChecked | Component view checked |
| ngOnDestroy | Component cleanup |

Example:

typescript

```typescript
export class UserComponent
  implements OnInit, OnDestroy {

  ngOnInit(): void {
    console.log('Component initialized');
  }

  ngOnDestroy(): void {
    console.log('Component destroyed');
  }
}
```

**Senior-level point:**

Avoid putting expensive operations inside `ngDoCheck` or frequently executed lifecycle hooks.

Use `DestroyRef`, `takeUntilDestroyed` or other appropriate cleanup mechanisms for subscriptions and resources.

---

## 5\. What is Angular change detection?

**Answer:**

Change detection is the process Angular uses to determine whether the application view needs updating.

Angular checks component state and updates the DOM when necessary.

Two commonly discussed strategies are:

1. Default change detection.
2. OnPush change detection.

Example:

typescript

```typescript
@Component({
  selector: 'app-user',
  changeDetection:
    ChangeDetectionStrategy.OnPush,
  template: '{{ userName }}'
})
export class UserComponent {

  userName = 'John';
}
```

OnPush reduces unnecessary checking by using specific change-detection triggers.

Important triggers include:

- New input values.
- Events handled in the component subtree.
- Signals read by the template being updated.
- Explicit change-detection notifications.

**Why use OnPush?**

It helps improve performance in large component trees when combined with immutable data patterns and well-designed state management.

---

## 6\. Default vs OnPush change detection?

**Answer:**

| Feature | Default | OnPush |
| --- | --- | --- |
| Change detection | More broadly checked | Checked under specific conditions |
| Performance | Can involve more checks | Can reduce unnecessary checks |
| Immutable updates | Useful | Particularly important for object inputs |
| Signals | Supported | Supported |
| Use case | General applications | Performance-sensitive components |

**Example problem:**

typescript

```typescript
user.name = 'David';
```

If the same object reference is passed to an OnPush child, the child might not receive a new input reference.

Better approach:

typescript

```typescript
user = {
  ...user,
  name: 'David'
};
```

This creates a new object reference.

---

## 7\. What are Angular Signals?

**Answer:**

Signals are a reactive state management primitive built into modern Angular.

They represent values that notify consumers when their state changes.

**Example:**

typescript

```typescript
import {
  signal,
  computed
} from '@angular/core';

export class CounterComponent {

  count = signal(0);

  doubleCount = computed(
    () => this.count() * 2
  );

  increment() {
    this.count.update(value => value + 1);
  }
}
```

**Important Signal APIs:**

- `signal()` – Creates writable state.
- `computed()` – Creates derived state.
- `effect()` – Executes side effects when tracked signals change.
- `input()` – Signal-based component input.
- `model()` – Supports model inputs and two-way binding.

**Signals vs RxJS:**

Signals are useful for synchronous reactive state.

RxJS is especially useful for asynchronous streams, events, cancellation, retries and complex stream composition.

They can be used together.

---

## 8\. What is RxJS and why does Angular use it?

**Answer:**

RxJS is a reactive programming library based on Observables.

Angular uses RxJS extensively for:

- HTTP requests.
- Form value changes.
- Router events.
- Event streams.
- Asynchronous operations.

Example:

typescript

```typescript
this.http.get<User[]>('/api/users')
  .subscribe(users => {
    this.users = users;
  });
```

**Observable characteristics:**

- Lazy execution in common cold Observable use cases.
- Supports multiple values.
- Supports operators.
- Supports cancellation through unsubscription.
- Supports error handling.

**Important:** An Observable can be cold or hot depending on how it is created and shared.

---

## 9\. Promise vs Observable?

**Answer:**

| Feature | Promise | Observable |
| --- | --- | --- |
| Values | One eventual result | Zero or more values |
| Execution | Eager once created | Usually lazy |
| Cancellation | No standard cancellation | Unsubscription |
| Operators | Limited native composition | Rich RxJS operators |
| Multiple values | No | Yes |
| Error handling | catch | catchError |

**Promise example:**

typescript

```typescript
const promise =
  fetch('/api/users').then(res => res.json());
```

**Observable example:**

typescript

```typescript
this.http.get('/api/users')
  .pipe(
    retry(2),
    catchError(error => {
      return throwError(() => error);
    })
  );
```

Use Promises for simple one-time asynchronous operations and Observables when stream composition and cancellation are useful.

---

## 10\. Explain important RxJS operators.

**Answer:**

### map

Transforms emitted values.

typescript

```typescript
source$.pipe(
  map(value => value * 2)
);
```

### switchMap

Cancels the previous inner subscription when a new source value arrives.

Useful for search autocomplete.

typescript

```typescript
searchControl.valueChanges.pipe(
  debounceTime(300),
  distinctUntilChanged(),
  switchMap(value =>
    this.userService.search(value)
  )
);
```

### mergeMap

Processes multiple inner Observables concurrently.

### concatMap

Processes inner Observables sequentially.

### exhaustMap

Ignores new source emissions while the previous inner Observable is active.

Useful for preventing repeated form submissions while a request is in progress.

### debounceTime

Waits for a quiet period before emitting.

### distinctUntilChanged

Avoids emitting consecutive duplicate values.

### catchError

Handles Observable errors.

### forkJoin

Waits for all supplied Observables to complete and returns their final values.

**Senior-level question:** When would you use switchMap versus mergeMap?

Use switchMap for latest-value-wins scenarios such as search.

Use mergeMap when concurrent execution is acceptable and each operation matters.

Use concatMap when operation order must be preserved.

---

## 11\. What is dependency injection in Angular?

**Answer:**

Dependency Injection is a design pattern where dependencies are provided to a class instead of being created directly inside it.

Example:

typescript

```typescript
@Injectable({
  providedIn: 'root'
})
export class UserService {

  getUsers() {
    return ['John', 'David'];
  }
}
```

Inject into component:

typescript

```typescript
@Component({
  selector: 'app-users',
  template: ''
})
export class UsersComponent {

  private userService = inject(UserService);

}
```

Benefits:

- Loose coupling.
- Reusability.
- Easier unit testing.
- Better maintainability.

Angular uses hierarchical injectors to resolve dependencies.

---

## 12\. Explain Angular routing and lazy loading.

**Answer:**

Angular Router provides navigation between application views without requiring a full-page reload.

Example:

typescript

```typescript
export const routes: Routes = [
  {
    path: 'users',
    loadComponent: () =>
      import('./users/users.component')
        .then(m => m.UsersComponent)
  }
];
```

Lazy loading loads feature code when required.

**Advantages:**

- Smaller initial JavaScript bundle.
- Faster initial application loading.
- Better feature separation.

Other important concepts:

- Route guards.
- Resolvers.
- Child routes.
- Route parameters.
- Query parameters.
- Preloading strategies.

---

## 13\. What are Angular route guards?

**Answer:**

Route guards control whether navigation can proceed.

Common guard types:

- CanActivate.
- CanActivateChild.
- CanDeactivate.
- CanMatch.
- Resolve.

Example:

typescript

```typescript
export const authGuard: CanActivateFn =
  () => {
    const authService = inject(AuthService);
    const router = inject(Router);

    return authService.isAuthenticated()
      ? true
      : router.createUrlTree(['/login']);
  };
```

**Important security point:**

Frontend guards improve navigation and user experience but are not security boundaries.

Backend APIs must independently validate authentication and authorization.

---

## 14\. What is the difference between template-driven and reactive forms?

**Answer:**

| Feature | Template-driven | Reactive |
| --- | --- | --- |
| Form definition | HTML template | TypeScript |
| Data flow | More implicit | Explicit |
| Validation | Template-based | Programmatic |
| Complex forms | Less convenient | Better suited |
| Testing | Relatively less direct | Easier to test |
| Dynamic controls | Less flexible | Highly flexible |

**Reactive form example:**

typescript

```typescript
form = new FormGroup({
  name: new FormControl('', [
    Validators.required
  ]),
  email: new FormControl('', [
    Validators.required,
    Validators.email
  ])
});
```

Submit:

typescript

```typescript
submit() {
  if (this.form.valid) {
    console.log(this.form.value);
  }
}
```

For enterprise applications with complex validation and dynamic forms, reactive forms are generally a good choice.

---

## 15\. How do you handle HTTP errors in Angular?

**Answer:**

I use RxJS error handling and HTTP interceptors.

Example:

typescript

```typescript
this.http.get('/api/users')
  .pipe(
    catchError(error => {

      console.error(error);

      return throwError(() => error);
    })
  );
```

**HTTP interceptor example:**

typescript

```typescript
export const errorInterceptor:
  HttpInterceptorFn = (req, next) => {

    return next(req).pipe(
      catchError(error => {

        if (error.status === 401) {
          // Handle authentication failure
        }

        return throwError(() => error);
      })
    );
  };
```

Interceptors are useful for:

- Authentication headers.
- Centralized error handling.
- Logging.
- Request correlation IDs.
- Loading indicators.

Avoid automatically retrying every error, especially non-idempotent operations.

---

## 16\. What is the difference between Subject and BehaviorSubject?

**Answer:**

| Feature | Subject | BehaviorSubject |
| --- | --- | --- |
| Initial value | Not required | Required |
| New subscriber | Receives future emissions | Immediately receives current value |
| Stores current value | No | Yes |
| Common use | Event notification | Shared current state |

Example:

typescript

```typescript
const subject = new Subject<number>();

const behavior =
  new BehaviorSubject<number>(0);
```

A BehaviorSubject is useful for representing current state in a service.

However, Angular Signals are another option for local synchronous state.

---

## 17\. What is the difference between ViewChild and ContentChild?

**Answer:**

`ViewChild` accesses an element or directive in the component's own template.

`ContentChild` accesses projected content supplied through content projection.

Example:

typescript

```typescript
@ViewChild('input')
input!: ElementRef;
```

Content projection:

HTMLWrap linesCopy codePreview

```html
<app-card>
  <h2>Projected content</h2>
</app-card>
```

The receiving component can use `ContentChild` to access projected elements.

---

## 18\. What is Angular content projection?

**Answer:**

Content projection allows a parent component to pass content into a child component using `ng-content`.

Example:

HTMLWrap linesCopy codePreview

```html
<!-- card.component.html -->

<div class="card">
  <ng-content></ng-content>
</div>
```

Usage:

HTMLWrap linesCopy codePreview

```html
<app-card>
  <h2>User Details</h2>
  <p>Angular Developer</p>
</app-card>
```

It improves component reusability.

Angular also supports multiple projection slots using selectors.

---

## 19\. What are Angular pipes?

**Answer:**

Pipes transform values for display in templates.

Built-in pipes include:

- DatePipe.
- CurrencyPipe.
- DecimalPipe.
- PercentPipe.
- JsonPipe.
- AsyncPipe.

Example:

HTMLWrap linesCopy codePreview

```html
<p>{{ amount | currency:'INR' }}</p>
```

Custom pipe:

typescript

```typescript
@Pipe({
  name: 'uppercaseFirst',
  standalone: true
})
export class UppercaseFirstPipe
  implements PipeTransform {

  transform(value: string): string {
    if (!value) return value;

    return value.charAt(0).toUpperCase()
      + value.slice(1);
  }
}
```

Pure pipes are evaluated when their input arguments change. Impure pipes may execute more frequently and should be used carefully.

---

## 20\. What are standalone components?

**Answer:**

Standalone components can be used without declaring them inside an NgModule.

Example:

typescript

```typescript
@Component({
  selector: 'app-user',
  standalone: true,
  imports: [CommonModule],
  template: '<h2>User Profile</h2>'
})
export class UserComponent {}
```

Benefits:

- Less module boilerplate.
- Easier component reuse.
- Simplified lazy loading.
- More direct dependency management.

Standalone APIs are the recommended direction for modern Angular application architecture.

---

# PART 2: TYPESCRIPT AND JAVASCRIPT – 15 QUESTIONS

## 21\. What is the difference between var, let and const?

| Feature | var | let | const |
| --- | --- | --- | --- |
| Scope | Function | Block | Block |
| Reassignment | Yes | Yes | No |
| Redeclaration | Yes in same scope | No | No |
| Hoisting | Yes, initialized as undefined | Yes, temporal dead zone | Yes, temporal dead zone |

Example:

typescript

```typescript
let age = 30;
age = 31;

const name = 'John';
```

Prefer const by default and let when reassignment is necessary.

---

## 22\. What are TypeScript interfaces and types?

**Answer:**

Both define shapes and contracts.

Interface:

typescript

```typescript
interface User {
  id: number;
  name: string;
}
```

Type:

typescript

```typescript
type User = {
  id: number;
  name: string;
};
```

Interfaces can be extended and declaration-merged.

Type aliases can represent unions, intersections, primitives, tuples and more complex types.

---

## 23\. What are generics in TypeScript?

**Answer:**

Generics allow reusable components and functions while preserving type safety.

Example:

typescript

```typescript
function identity<T>(value: T): T {
  return value;
}

const result = identity<string>('Angular');
```

API response example:

typescript

```typescript
interface ApiResponse<T> {
  data: T;
  success: boolean;
}

const response: ApiResponse<User> = {
  data: {
    id: 1,
    name: 'John'
  },
  success: true
};
```

---

## 24\. What is the difference between any and unknown?

**Answer:**

`any` disables much of TypeScript's type checking.

`unknown` requires type checking before using the value.

typescript

```typescript
let value: unknown = 'Angular';

if (typeof value === 'string') {
  console.log(value.toUpperCase());
}
```

Prefer unknown when the type is not known in advance.

---

## 25\. Explain optional chaining and nullish coalescing.

**Answer:**

Optional chaining:

typescript

```typescript
const city = user?.address?.city;
```

Nullish coalescing:

typescript

```typescript
const name = user.name ?? 'Guest';
```

Unlike `||`, the nullish operator only uses the fallback for null or undefined, not for values such as 0 or an empty string.

---

## 26\. What is the difference between == and ===?

`==` performs type coercion.

`===` checks strict equality without type coercion.

typescript

```typescript
5 == '5';  // true
5 === '5'; // false
```

Prefer strict equality.

---

## 27\. Explain JavaScript event loop.

**Answer:**

JavaScript uses an event loop to coordinate execution of synchronous code and asynchronous callbacks.

Important concepts:

- Call stack.
- Browser or runtime APIs.
- Task queue.
- Microtask queue.
- Event loop.

Promise callbacks are scheduled as microtasks.

Timers such as setTimeout schedule tasks.

Microtasks are generally processed before the next task begins.

---

## 28\. What is closure?

**Answer:**

A closure is created when a function retains access to variables from its lexical scope.

Example:

typescript

```typescript
function counter() {
  let count = 0;

  return function () {
    return ++count;
  };
}

const increment = counter();

increment(); // 1
increment(); // 2
```

Closures are useful for encapsulation and function factories.

---

## 29\. What is hoisting?

**Answer:**

Hoisting describes how JavaScript handles declarations during execution-context creation.

Function declarations can be called before their declaration in the source code.

`var` declarations are initialized with undefined.

`let` and `const` remain in the temporal dead zone until initialization.

---

## 30\. Explain shallow copy vs deep copy.

**Answer:**

Shallow copy copies top-level properties but nested objects remain shared references.

typescript

```typescript
const copy = { ...original };
```

For supported structured-cloneable values:

typescript

```typescript
const deepCopy = structuredClone(original);
```

The correct approach depends on data types, class instances and serialization requirements.

---

## 31\. What are map, filter and reduce?

**Answer:**

Map transforms elements.

Filter selects elements.

Reduce combines elements into one result.

typescript

```typescript
const numbers = [1, 2, 3, 4];

const doubled =
  numbers.map(n => n * 2);

const even =
  numbers.filter(n => n % 2 === 0);

const total =
  numbers.reduce((sum, n) => sum + n, 0);
```

---

## 32\. What is the difference between call, apply and bind?

**Answer:**

These methods control the `this` context of a function.

- call: invokes with individual arguments.
- apply: invokes with an array of arguments.
- bind: returns a new function with bound context.

typescript

```typescript
function greet(city: string) {
  return `${this.name} from ${city}`;
}
```

---

## 33\. What is async/await?

**Answer:**

Async/await provides syntax for working with Promises.

typescript

```typescript
async function getUsers() {
  try {
    const response = await fetch('/api/users');

    return await response.json();

  } catch (error) {
    console.error(error);
  }
}
```

It makes asynchronous code easier to read but does not make operations synchronous.

---

## 34\. What is immutability?

**Answer:**

Immutability means avoiding modification of existing objects and instead creating new values.

Example:

typescript

```typescript
const updatedUser = {
  ...user,
  name: 'David'
};
```

Benefits:

- Predictable state changes.
- Easier debugging.
- Better integration with OnPush.
- Easier state comparison.

---

## 35\. What is the difference between null and undefined?

`undefined` commonly indicates that a value has not been assigned.

`null` represents an intentionally absent value.

Use clear contracts and strict TypeScript settings to handle both safely.

---

# PART 3: ANGULAR PERFORMANCE OPTIMIZATION – 12 QUESTIONS

## 36\. How do you improve Angular application performance?

**Answer:**

I investigate application performance before implementing optimizations.

Important techniques:

1. Lazy loading.
2. OnPush change detection.
3. Signals for suitable reactive state.
4. Avoid unnecessary subscriptions.
5. Use track in @for.
6. Virtual scrolling for large lists.
7. Optimize bundle size.
8. Use pure pipes.
9. Avoid unnecessary DOM operations.
10. Use image optimization.
11. Cache suitable API responses.
12. Use production builds.

Example:

HTMLWrap linesCopy codePreview

```html
@for (user of users; track user.id) {
  <div>{{ user.name }}</div>
}
```

Tracking by stable IDs helps Angular identify list items efficiently.

---

## 37\. What is lazy loading?

Lazy loading loads feature code only when required.

Example:

typescript

```typescript
{
  path: 'admin',
  loadChildren: () =>
    import('./admin/admin.routes')
      .then(m => m.ADMIN_ROUTES)
}
```

Benefits:

- Smaller initial bundle.
- Better initial loading.
- Feature isolation.

---

## 38\. What is Angular virtual scrolling?

Virtual scrolling renders only the visible portion of a large list.

For example, instead of rendering 50,000 rows, it renders a smaller visible window and updates it as the user scrolls.

Angular CDK provides virtual scrolling support.

Benefits:

- Lower DOM node count.
- Better rendering performance.
- Reduced memory usage.

---

## 39\. What is trackBy or track in Angular?

Tracking helps Angular identify which items have changed in a collection.

Modern syntax:

HTMLWrap linesCopy codePreview

```html
@for (user of users; track user.id) {
  <div>{{ user.name }}</div>
}
```

Traditional syntax:

HTMLWrap linesCopy codePreview

```html
<div
  *ngFor="let user of users; trackBy: trackById">
  {{ user.name }}
</div>
```

typescript

```typescript
trackById(index: number, user: User) {
  return user.id;
}
```

---

## 40\. What is lazy image loading?

Lazy image loading delays loading images until they approach the viewport.

HTMLWrap linesCopy codePreview

```html
<img
  src="profile.jpg"
  loading="lazy"
  alt="Profile">
```

It reduces unnecessary initial network requests.

Do not lazy-load images that are critical for initial rendering, such as the main hero image.

---

## 41\. How do you optimize Angular bundle size?

**Answer:**

- Lazy-load routes.
- Remove unused dependencies.
- Use tree-shakable imports.
- Avoid unnecessary third-party libraries.
- Use production builds.
- Inspect bundle analyzer output.
- Use deferred loading where appropriate.

Modern Angular supports `@defer` for deferrable views.

Example:

HTMLWrap linesCopy codePreview

```html
@defer (on viewport) {
  <app-heavy-dashboard />
} @placeholder {
  <p>Loading dashboard...</p>
}
```

---

## 42\. What is server-side rendering in Angular?

**Answer:**

Server-side rendering generates HTML on the server before sending it to the browser.

Benefits:

- Faster initial content display in suitable cases.
- Better search engine discoverability.
- Improved perceived performance.

Angular supports SSR and prerendering.

Considerations:

- Browser APIs may not exist on the server.
- Server and browser rendering must remain consistent.
- Hydration must be handled correctly.

---

## 43\. What is hydration?

**Answer:**

Hydration reuses server-rendered HTML and attaches Angular behavior in the browser.

It avoids unnecessarily recreating the entire DOM.

Angular supports hydration as part of its SSR capabilities.

---

## 44\. What is Web Worker?

**Answer:**

Web Workers execute JavaScript in a background thread separate from the main browser UI thread.

Useful for:

- Heavy calculations.
- Data processing.
- CPU-intensive tasks.

They cannot directly manipulate the DOM.

---

## 45\. What causes memory leaks in Angular?

**Answer:**

Common causes:

- Subscriptions not cleaned up.
- Event listeners not removed.
- Timers not cleared.
- Detached DOM references.
- Large caches.
- References retained by services.

Solution:

typescript

```typescript
private destroyRef = inject(DestroyRef);

ngOnInit() {
  this.userService.users$
    .pipe(takeUntilDestroyed(this.destroyRef))
    .subscribe(users => {
      this.users = users;
    });
}
```

Also inspect browser heap snapshots and allocation timelines.

---

## 46\. What is @defer in Angular?

**Answer:**

`@defer` delays loading and rendering part of a template.

Example:

HTMLWrap linesCopy codePreview

```html
@defer (on interaction) {
  <app-report />
} @placeholder {
  <button>Load report</button>
}
```

It is useful for large, non-critical UI sections.

---

## 47\. What is the difference between CSR, SSR and SSG?

**Answer:**

| Rendering | Meaning |
| --- | --- |
| CSR | Browser renders the application |
| SSR | Server renders HTML per request |
| SSG | HTML is generated ahead of time |

Use the rendering approach based on SEO, initial loading, personalization and infrastructure requirements.

---

# PART 4: ANGULAR ARCHITECTURE AND ADVANCED CONCEPTS

## 48\. How do you structure a large Angular application?

**Answer:**

I prefer feature-oriented architecture.

Example:

text

```text
src/
  app/
    core/
      auth/
      interceptors/
      guards/

    shared/
      components/
      pipes/
      directives/

    features/
      users/
        components/
        services/
        models/
        pages/

      orders/
        components/
        services/
        models/
        pages/

    app.routes.ts
```

**Core:** Application-wide services and infrastructure.

**Shared:** Reusable components and utilities.

**Features:** Business functionality grouped by domain.

This makes applications easier to maintain and scale across teams.

---

## 49\. What is the difference between NgModule and standalone architecture?

**Answer:**

NgModule-based applications group components, directives and pipes into modules.

Standalone architecture allows components to declare their own dependencies.

Standalone architecture reduces boilerplate and simplifies lazy loading.

Existing NgModule applications can still be maintained and migrated incrementally.

---

## 50\. What is state management in Angular?

**Answer:**

State management controls how application data is stored, updated and shared.

Approaches:

1. Component state.
2. Shared service with Signals.
3. RxJS BehaviorSubject.
4. NgRx Store.
5. NgRx ComponentStore or SignalStore.

Use local component state for isolated UI state.

Use shared services for simpler cross-component state.

Use NgRx when application complexity, shared workflows, debugging and team requirements justify a centralized state-management solution.

---

## 51\. What is NgRx?

**Answer:**

NgRx is a state management library inspired by Redux.

Main concepts:

- Store.
- Actions.
- Reducers.
- Selectors.
- Effects.

Architecture:

text

```text
Component
   |
   v
Action
   |
   v
Reducer
   |
   v
Store
   |
   v
Selector
   |
   v
Component
```

Effects handle asynchronous operations such as HTTP calls.

Advantages:

- Predictable state changes.
- Centralized state.
- Time-travel debugging support through developer tooling.
- Clear separation of concerns.

---

## 52\. What are Angular interceptors?

**Answer:**

Interceptors allow HTTP requests and responses to be processed centrally.

Use cases:

- Add authorization headers.
- Add correlation IDs.
- Logging.
- Error handling.
- Loading indicators.

Modern functional interceptor example:

typescript

```typescript
export const authInterceptor:
  HttpInterceptorFn = (req, next) => {

    const token =
      inject(AuthService).getToken();

    const clonedRequest = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });

    return next(clonedRequest);
  };
```

Never expose sensitive credentials unnecessarily or store authentication secrets in unsafe locations.

---

## 53\. How do you implement role-based access control?

**Answer:**

The frontend can hide or disable features based on user roles.

Example:

typescript

```typescript
if (user.roles.includes('ADMIN')) {
  // Show admin features
}
```

However, authorization must always be enforced by the backend.

Frontend checks are not sufficient security controls.

---

## 54\. What is CORS?

**Answer:**

Cross-Origin Resource Sharing is a browser security mechanism that controls whether a webpage can access resources from another origin.

An origin consists of:

- Scheme.
- Host.
- Port.

The backend must return appropriate CORS headers.

CORS is not a replacement for authentication or authorization.

---

## 55\. How do you handle environment configurations?

**Answer:**

Angular supports build-time environment configuration through file replacements and configuration-specific builds.

Example:

typescript

```typescript
export const environment = {
  production: true,
  apiUrl: 'https://api.example.com'
};
```

Never put private secrets in frontend environment files because frontend code and bundled configuration are visible to users.

For runtime configuration, load appropriate public configuration from a controlled endpoint.

---

# PART 5: REAL-WORLD ANGULAR SCENARIO QUESTIONS

## 56\. Angular application becomes slow after some time. How do you troubleshoot?

**Answer:**

I investigate:

1. Browser memory usage.
2. CPU utilization.
3. Number of DOM nodes.
4. Component rendering frequency.
5. Subscription cleanup.
6. Repeated API requests.
7. Change detection.
8. Third-party library behavior.

Tools:

- Chrome DevTools.
- Angular DevTools.
- Performance profiler.
- Memory heap snapshots.
- Network tab.

Possible causes:

- Memory leaks.
- Excessive subscriptions.
- Large DOM trees.
- Unoptimized lists.
- Repeated API calls.

I identify the actual issue and validate the improvement with profiling.

---

## 57\. API is called multiple times unnecessarily. How do you solve it?

**Answer:**

Possible causes:

- Multiple subscriptions.
- Multiple component instances.
- HTTP calls inside frequently evaluated template methods.
- Duplicate event handlers.
- Repeated route initialization.

Solutions:

Use shared streams when appropriate:

typescript

```typescript
users$ = this.http.get<User[]>('/api/users')
  .pipe(
    shareReplay({
      bufferSize: 1,
      refCount: true
    })
  );
```

Use the AsyncPipe:

HTMLWrap linesCopy codePreview

```html
@for (user of users$ | async; track user.id) {
  <p>{{ user.name }}</p>
}
```

Be careful with `shareReplay`: its caching and subscription lifecycle should match the required freshness policy.

---

## 58\. How do you prevent duplicate form submissions?

**Answer:**

Use an in-flight state and disable the submit button.

Example:

typescript

```typescript
isSubmitting = false;

submit() {
  if (this.isSubmitting) return;

  this.isSubmitting = true;

  this.userService.save(this.form.value)
    .pipe(
      finalize(() => {
        this.isSubmitting = false;
      })
    )
    .subscribe();
}
```

For complex flows, use exhaustMap.

The backend must also enforce idempotency for business-critical operations.

---

## 59\. Search API is called on every keystroke. How do you optimize it?

**Answer:**

Use RxJS operators.

typescript

```typescript
this.searchControl.valueChanges
  .pipe(
    debounceTime(300),
    distinctUntilChanged(),
    filter(value => value.length >= 2),
    switchMap(value =>
      this.searchService.search(value)
    )
  )
  .subscribe(results => {
    this.results = results;
  });
```

Benefits:

- Reduces API requests.
- Cancels previous inner requests where supported.
- Displays results for the latest search term.

---

## 60\. How do you handle authentication token expiration?

**Answer:**

I handle token expiration centrally using HTTP interceptors and authentication services.

Possible flow:

1. API returns 401.
2. Interceptor checks whether refresh is appropriate.
3. Refresh token workflow is initiated.
4. Original request is retried when safe.
5. If refresh fails, user is redirected to login.

Important:

- Prevent multiple concurrent refresh requests.
- Avoid infinite retry loops.
- Handle refresh-token expiration.
- Use secure cookie-based strategies where appropriate.
- Ensure backend authorization remains authoritative.

---

## 61\. How do you handle global errors?

**Answer:**

Use Angular's global ErrorHandler and HTTP interceptors.

Example:

typescript

```typescript
@Injectable()
export class GlobalErrorHandler
  implements ErrorHandler {

  handleError(error: unknown): void {
    console.error('Application error:', error);
  }
}
```

For production:

- Send sanitized error information to monitoring.
- Include correlation IDs where available.
- Avoid exposing sensitive user information.
- Display user-friendly error messages.

---

## 62\. How do you optimize a large table with 100,000 records?

**Answer:**

I would not render all 100,000 records at once.

Solutions:

- Server-side pagination.
- Virtual scrolling.
- Filtering on the backend.
- Sorting on the backend.
- Debounced search.
- Lazy data loading.
- Stable row tracking.

Also avoid excessive DOM nodes and expensive template expressions.

---

## 63\. How do you handle multiple API calls in parallel?

**Answer:**

Use forkJoin when all calls are finite and completion of every call is required.

typescript

```typescript
forkJoin({
  users: this.userService.getUsers(),
  orders: this.orderService.getOrders(),
  products: this.productService.getProducts()
}).subscribe(result => {

  this.users = result.users;
  this.orders = result.orders;
  this.products = result.products;

});
```

Use combineLatest when ongoing streams should emit whenever one source changes after all have emitted.

Use appropriate error handling if individual API failures should not fail the entire combined operation.

---

## 64\. How do you handle file uploads in Angular?

**Answer:**

Use FormData.

typescript

```typescript
uploadFile(file: File) {

  const formData = new FormData();

  formData.append('file', file);

  return this.http.post(
    '/api/upload',
    formData
  );
}
```

Important considerations:

- File size limits.
- File type validation.
- Upload progress.
- Cancellation.
- Server-side validation.
- Secure storage.
- Malware scanning where appropriate.

---

## 65\. How do you implement real-time updates?

**Answer:**

Possible approaches:

- WebSockets.
- Server-Sent Events.
- Polling.

WebSockets support two-way communication.

SSE supports server-to-client event streaming.

Polling periodically requests updates.

Choose based on latency, communication direction, infrastructure and connection requirements.

---

# PART 6: ANGULAR TESTING QUESTIONS

## 66\. What is unit testing in Angular?

**Answer:**

Unit testing verifies individual components, services, pipes and other isolated units.

Common tools:

- Jasmine.
- Karma.
- Jest.
- Vitest, depending on project setup.

Example:

typescript

```typescript
describe('CounterComponent', () => {

  it('should increment counter', () => {

    const component = new CounterComponent();

    component.increment();

    expect(component.count()).toBe(1);

  });

});
```

---

## 67\. How do you test Angular services?

**Answer:**

Use TestBed and dependency injection.

For HTTP services, use HttpTestingController.

typescript

```typescript
TestBed.configureTestingModule({
  providers: [
    provideHttpClient(),
    provideHttpClientTesting()
  ]
});

const httpMock =
  TestBed.inject(HttpTestingController);
```

Then:

1. Call the service.
2. Expect the HTTP request.
3. Flush a mock response.
4. Assert the result.
5. Verify outstanding requests.

---

## 68\. What is the difference between unit, integration and end-to-end testing?

| Type | Purpose |
| --- | --- |
| Unit | Test individual units |
| Integration | Test interaction between units |
| E2E | Test complete user workflows |

Tools:

- Jasmine/Jest/Vitest for unit tests.
- Angular testing utilities for component integration.
- Playwright or Cypress for E2E.

---

## 69\. How do you test RxJS Observables?

**Answer:**

You can subscribe and assert emissions.

For complex timing behavior, use RxJS TestScheduler.

TestScheduler supports virtual time and marble testing.

It is particularly useful for testing debounceTime, switchMap and other asynchronous stream behavior.

---

## 70\. How do you mock dependencies in Angular tests?

**Answer:**

Use provider overrides or provide mock objects.

typescript

```typescript
providers: [
  {
    provide: UserService,
    useValue: {
      getUsers: jasmine
        .createSpy()
        .and.returnValue(of([]))
    }
  }
]
```

This allows testing components independently from real backend services.

---

# PART 7: IMPORTANT ANGULAR CODING QUESTIONS

Practice implementing these without relying on an IDE.

1. Reverse a string.
2. Find duplicate elements in an array.
3. Find the second-highest number.
4. Remove duplicate objects based on ID.
5. Sort an array of employees by salary.
6. Implement a custom Angular pipe.
7. Create a reusable directive.
8. Create a custom validator.
9. Implement an HTTP interceptor.
10. Implement an authentication guard.
11. Implement search autocomplete using RxJS.
12. Implement a reusable modal component.
13. Implement pagination.
14. Implement file upload.
15. Implement an observable-based shared service.
16. Implement a Signal-based counter.
17. Implement a custom debounce function.
18. Implement a generic API response interface.
19. Implement a dynamic reactive form.
20. Implement a reusable table component.

### Example: Remove duplicate objects by ID

typescript

```typescript
const users = [
  { id: 1, name: 'John' },
  { id: 2, name: 'David' },
  { id: 1, name: 'John' }
];

const uniqueUsers = [
  ...new Map(
    users.map(user => [user.id, user])
  ).values()
];
```

### Example: Second-highest number

typescript

```typescript
const numbers = [10, 20, 30, 30, 40];

const secondHighest = numbers
  .filter((value, index, array) =>
    array.indexOf(value) === index
  )
  .sort((a, b) => b - a)[1];
```

### Example: Custom email validator

typescript

```typescript
export function customEmailValidator(
  control: AbstractControl
): ValidationErrors | null {

  const value = control.value;

  if (!value) return null;

  const valid =
    /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value);

  return valid ? null : {
    invalidEmail: true
  };
}
```

---

# PART 8: FRONTEND SYSTEM DESIGN QUESTIONS

Prepare the following architecture discussions.

1. Design an enterprise Angular application.
2. Design a dashboard with multiple widgets.
3. Design an e-commerce frontend.
4. Design a role-based admin portal.
5. Design a reusable component library.
6. Design a real-time notification system.
7. Design a large dynamic form engine.
8. Design a high-performance data table.
9. Design frontend authentication and authorization.
10. Design a multi-tenant Angular application.

For each design, discuss:

- Component hierarchy.
- Feature organization.
- Routing.
- State management.
- API integration.
- Authentication.
- Error handling.
- Performance.
- Accessibility.
- Testing.
- Deployment.

---

# PART 9: ANGULAR 20 MODERN FEATURES TO PREPARE

Modern Angular interviews may include questions about the following:

| Feature | What to understand |
| --- | --- |
| Standalone components | Component-level imports |
| Signals | Reactive state management |
| Computed | Derived reactive state |
| Effect | Reactive side effects |
| Signal inputs | Reactive component inputs |
| Model inputs | Two-way component binding |
| New control flow | @if, @for, @switch |
| @defer | Deferred view loading |
| takeUntilDestroyed | Subscription cleanup |
| Functional interceptors | Modern HTTP interception |
| Functional guards | Modern route protection |
| SSR | Server-side rendering |
| Hydration | Reusing server-rendered HTML |
| Zoneless change detection | Change detection without relying on ZoneJS |
| Resource APIs | Reactive asynchronous resource management |

**Version note:** Not every feature has the same stability status across Angular releases. Verify the API and maturity level against the exact Angular version used by the project.

---

# PART 10: SEVEN-DAY ANGULAR INTERVIEW PREPARATION PLAN

| Day | Topics |
| --- | --- |
| Day 1 | TypeScript, JavaScript, ES6+ |
| Day 2 | Components, lifecycle, directives, pipes |
| Day 3 | RxJS, Observables, Subjects, operators |
| Day 4 | Change detection, Signals, DI, routing |
| Day 5 | Reactive forms, HTTP, interceptors, security |
| Day 6 | Performance, testing, architecture |
| Day 7 | Scenario-based questions and mock interview |

---

# PART 11: FINAL ANGULAR INTERVIEW REVISION CHECKLIST

## Angular fundamentals

- [ ]Components.
- [ ]Directives.
- [ ]Pipes.
- [ ]Lifecycle hooks.
- [ ]Dependency Injection.
- [ ]Standalone components.
- [ ]NgModules.
- [ ]Content projection.
- [ ]ViewChild and ContentChild.

## TypeScript and JavaScript

- [ ]var, let and const.
- [ ]Interfaces and types.
- [ ]Generics.
- [ ]Closures.
- [ ]Hoisting.
- [ ]Promises.
- [ ]Async/await.
- [ ]Event loop.
- [ ]Map, filter and reduce.
- [ ]Optional chaining.

## RxJS

- [ ]Observable.
- [ ]Subject.
- [ ]BehaviorSubject.
- [ ]ReplaySubject.
- [ ]switchMap.
- [ ]mergeMap.
- [ ]concatMap.
- [ ]exhaustMap.
- [ ]forkJoin.
- [ ]combineLatest.
- [ ]debounceTime.
- [ ]distinctUntilChanged.
- [ ]catchError.
- [ ]shareReplay.

## Advanced Angular

- [ ]Signals.
- [ ]Computed.
- [ ]Effect.
- [ ]OnPush.
- [ ]Change detection.
- [ ]Routing.
- [ ]Guards.
- [ ]Resolvers.
- [ ]Reactive forms.
- [ ]HTTP interceptors.
- [ ]Lazy loading.
- [ ]SSR and hydration.

## Performance and security

- [ ]Bundle optimization.
- [ ]Virtual scrolling.
- [ ]Memory leak detection.
- [ ]Subscription cleanup.
- [ ]Image optimization.
- [ ]Authentication.
- [ ]Authorization.
- [ ]XSS prevention.
- [ ]CORS.
- [ ]Secure token handling.

## Testing and architecture

- [ ]Unit testing.
- [ ]Integration testing.
- [ ]E2E testing.
- [ ]TestBed.
- [ ]HttpTestingController.
- [ ]Feature-based architecture.
- [ ]NgRx.
- [ ]Reusable components.
- [ ]Accessibility.
- [ ]Build and deployment.

---

# FINAL INTERVIEW ADVICE

For a Senior Angular Developer interview, knowing decorators and syntax is not enough.

Interviewers want to understand whether you can:

1. Build scalable frontend applications.
2. Design reusable components.
3. Manage complex application state.
4. Handle asynchronous operations using RxJS.
5. Optimize Angular rendering performance.
6. Prevent memory leaks.
7. Design secure frontend applications.
8. Integrate frontend and backend microservices.
9. Build maintainable enterprise architecture.
10. Mentor developers and make technical decisions.

## Five topics to master

1. RxJS operators and asynchronous programming.
2. Change detection, OnPush and Signals.
3. Angular architecture and dependency injection.
4. Performance optimization and memory leak troubleshooting.
5. Real-world scenarios involving APIs, authentication and state management.

**Most important:** Prepare at least two real project examples. Explain how you designed the application, solved a performance problem, handled API failures and improved code maintainability.

A senior engineer should be able to explain not only how something works, but also why a particular implementation was selected and what alternatives were considered.

Suggested filename: `Senior_Angular_Developer_Interview_Preparation.md`

You can save the complete document with this filename and open it in VS Code or any Markdown editor.

My recommendation: If you are preparing for a Senior Full Stack Java + Angular interview, prepare the integration scenarios too: Angular authentication with Spring Security, JWT refresh, RxJS API orchestration, pagination, file upload, error handling and end-to-end performance optimization.

### The Travelling Salesman problem

- Deterministic Algorithm Implementation sample output on different runs produces the same results for final distance.

```console
Initial distance: 40
Finished
Final distance: 20
Solution: >> tspdynamic.City@4517d9a3 >> tspdynamic.City@372f7a8d >> tspdynamic.City@2f92e0f4 >> tspdynamic.City@28a418fc >> tspdynamic.City@5305068a >> tspdynamic.City@1f32e575 >> tspdynamic.City@279f2327 >> tspdynamic.City@2ff4acd0 >> tspdynamic.City@54bedef2 >> tspdynamic.City@5caf905d >> tspdynamic.City@27716f4 >> tspdynamic.City@8efb846 >> tspdynamic.City@2a84aee7 >> tspdynamic.City@a09ee92 >> tspdynamic.City@30f39991 >> tspdynamic.City@452b3a41 >> tspdynamic.City@4a574795 >> tspdynamic.City@f6f4d33 >> tspdynamic.City@23fc625e >> tspdynamic.City@3f99bd52 >>
```

```console
Initial distance: 44
Finished
Final distance: 20
Solution: >> tspdynamic.City@4517d9a3 >> tspdynamic.City@372f7a8d >> tspdynamic.City@2f92e0f4 >> tspdynamic.City@28a418fc >> tspdynamic.City@5305068a >> tspdynamic.City@1f32e575 >> tspdynamic.City@279f2327 >> tspdynamic.City@2ff4acd0 >> tspdynamic.City@54bedef2 >> tspdynamic.City@5caf905d >> tspdynamic.City@27716f4 >> tspdynamic.City@8efb846 >> tspdynamic.City@2a84aee7 >> tspdynamic.City@a09ee92 >> tspdynamic.City@30f39991 >> tspdynamic.City@452b3a41 >> tspdynamic.City@4a574795 >> tspdynamic.City@f6f4d33 >> tspdynamic.City@23fc625e >> tspdynamic.City@3f99bd52 >>
```

```console
Initial distance: 28
Finished
Final distance: 20
Solution: >> tspdynamic.City@4517d9a3 >> tspdynamic.City@372f7a8d >> tspdynamic.City@2f92e0f4 >> tspdynamic.City@28a418fc >> tspdynamic.City@5305068a >> tspdynamic.City@1f32e575 >> tspdynamic.City@279f2327 >> tspdynamic.City@2ff4acd0 >> tspdynamic.City@54bedef2 >> tspdynamic.City@5caf905d >> tspdynamic.City@27716f4 >> tspdynamic.City@8efb846 >> tspdynamic.City@2a84aee7 >> tspdynamic.City@a09ee92 >> tspdynamic.City@30f39991 >> tspdynamic.City@452b3a41 >> tspdynamic.City@4a574795 >> tspdynamic.City@f6f4d33 >> tspdynamic.City@23fc625e >> tspdynamic.City@3f99bd52 >>
```

- Non-Deterministic Algorithm Implementation
- The non deterministic algorithm is implemented using Simulated Annealing method. The mothod involves creating a temperature variable to simulate the heating/cooling process of metals. It is initially set to high value and allow the value to reduce slowly allowing the algorithm to accept solutions that are worse than the current solution.As the value for temperature reduces, the chance of accepting worse solutions also reduces, thereby allowing the algorithm to gradually focus in on a area of the search space in which a close to optimum solution can be found. Sample output on different runs produces different results:

```console
Initial solution distance:2030
Final solution distance: 988
Tour:  >> tspnondeterministic.City@5ca881b5 >> tspnondeterministic.City@24d46ca6 >> tspnondeterministic.City@4517d9a3 >> 	tspnondeterministic.City@372f7a8d >> tspnondeterministic.City@2f92e0f4 >> tspnondeterministic.City@28a418fc >> tspnondeterministic.City@5305068a >> 	tspnondeterministic.City@1f32e575 >> tspnondeterministic.City@279f2327 >> tspnondeterministic.City@2ff4acd0 >> tspnondeterministic.City@54bedef2 >> 	tspnondeterministic.City@5caf905d >> tspnondeterministic.City@27716f4 >> tspnondeterministic.City@8efb846 >> tspnondeterministic.City@2a84aee7 >> 	tspnondeterministic.City@a09ee92 >> tspnondeterministic.City@30f39991 >> tspnondeterministic.City@452b3a41 >> tspnondeterministic.City@4a574795 >> 	tspnondeterministic.City@f6f4d33 >>
```

```console
Initial solution distance:2422
Final solution distance: 881
Tour:  >> tspnondeterministic.City@5ca881b5 >> tspnondeterministic.City@24d46ca6 >> tspnondeterministic.City@4517d9a3 >> 	tspnondeterministic.City@372f7a8d >> tspnondeterministic.City@2f92e0f4 >> tspnondeterministic.City@28a418fc >> tspnondeterministic.City@5305068a >> 	tspnondeterministic.City@1f32e575 >> tspnondeterministic.City@279f2327 >> tspnondeterministic.City@2ff4acd0 >> tspnondeterministic.City@54bedef2 >> 	tspnondeterministic.City@5caf905d >> tspnondeterministic.City@27716f4 >> tspnondeterministic.City@8efb846 >> tspnondeterministic.City@2a84aee7 >> 	tspnondeterministic.City@a09ee92 >> tspnondeterministic.City@30f39991 >> tspnondeterministic.City@452b3a41 >> tspnondeterministic.City@4a574795 >> 	tspnondeterministic.City@f6f4d33 >>
```

```console
Initial solution distance:2164
Final solution distance: 913
Tour:  >> tspnondeterministic.City@5ca881b5 >> tspnondeterministic.City@24d46ca6 >> tspnondeterministic.City@4517d9a3 >> 	tspnondeterministic.City@372f7a8d >> tspnondeterministic.City@2f92e0f4 >> tspnondeterministic.City@28a418fc >> tspnondeterministic.City@5305068a >> 	tspnondeterministic.City@1f32e575 >> tspnondeterministic.City@279f2327 >> tspnondeterministic.City@2ff4acd0 >> tspnondeterministic.City@54bedef2 >> 	tspnondeterministic.City@5caf905d >> tspnondeterministic.City@27716f4 >> tspnondeterministic.City@8efb846 >> tspnondeterministic.City@2a84aee7 >> 	tspnondeterministic.City@a09ee92 >> tspnondeterministic.City@30f39991 >> tspnondeterministic.City@452b3a41 >> tspnondeterministic.City@4a574795 >> 	tspnondeterministic.City@f6f4d33 >>
```

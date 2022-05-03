package karazin.scala.users.group.week1.and.three.quarters.homework

object polymorphicfunctions extends App:

  // it works!!!
  val `I₍₂,₄₎⁴`: [`α₁`, `α₂`, `α₃`, `α₄`] ⇒ `α₁` ⇒ `α₂` ⇒ `α₃` ⇒ `α₄` ⇒ (`α₂`, `α₄`) =
    [`α₁`, `α₂`, `α₃`, `α₄`] ⇒ (`x₁`: `α₁`) ⇒ (`x₂`: `α₂`) ⇒ (`x₃`: `α₃`) ⇒ (`x₄`: `α₄`) ⇒ (`x₂`, `x₄`);

  val `(f ० g ० h ० i)(x)`: [ε, δ, γ, β, α] ⇒ (δ ⇒ ε) ⇒ ((γ ⇒ δ) ⇒ ((β ⇒ γ) ⇒ ((α ⇒ β) ⇒ (α ⇒ ε)))) =
    [ε, δ, γ, β, α] ⇒ (f: (δ ⇒ ε)) ⇒ (g: (γ ⇒ δ)) ⇒ (h: (β ⇒ γ)) ⇒ (i: (α ⇒ β)) ⇒ (x: α) ⇒ f(g(h(i(x))));

end polymorphicfunctions
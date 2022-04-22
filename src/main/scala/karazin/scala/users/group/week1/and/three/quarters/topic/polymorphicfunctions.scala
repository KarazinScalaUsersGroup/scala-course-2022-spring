package karazin.scala.users.group.week1.and.three.quarters.topic

object polymorphicfunctions extends App:
  
  val `I₂³`: [`α₁`, `α₂`, `α₃`] ⇒ `α₁` ⇒ `α₂` ⇒ `α₃` ⇒ `α₂` =
    [`α₁`, `α₂`, `α₃`] ⇒ (`x₁`: `α₁`) ⇒ (`x₂`: `α₂`) ⇒ (`x₃`: `α₃`) ⇒ `x₂`

  val `(f ० g)(x)`: [γ, β, α] ⇒ (β ⇒ γ) ⇒ ((α ⇒ β) ⇒ (α ⇒ γ)) =
    [γ, β, α] ⇒ (f: (β ⇒ γ)) ⇒ (g: (α ⇒ β)) ⇒ (x: α) ⇒ f(g(x))

end polymorphicfunctions

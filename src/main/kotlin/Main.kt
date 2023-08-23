import org.jooq.impl.DSL

fun main() {
    val ctx = DSL.using("jdbc://...")
    // ctx is an instance of DSLContext which is a Builder pattern, not a map!
    ctx.insertInto(DSL.dual())
        .set(DSL.field("foo1"), "bar") // S6518 false positive
        .set(DSL.field("foo2"), "baz") // %
        .set(DSL.field("foo3"), "bug") // %
        .execute()
}

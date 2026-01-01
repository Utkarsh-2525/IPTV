type Props = {
    value: string;
    onChange: (v: string) => void;
};

export default function CountrySelect({ value, onChange }: Props) {
    return (
        <select
            value={value}
            onChange={e => onChange(e.target.value)}
            style={{
                width: "100%",
                padding: 10,
                background: "#111",
                color: "#fff",
                border: "none"
            }}
        >
            <option value="in">🇮🇳 India</option>
            <option value="us">🇺🇸 USA</option>
            <option value="gb">🇬🇧 UK</option>
            <option value="ca">🇨🇦 Canada</option>
            <option value="au">🇦🇺 Australia</option>
        </select>
    );
}
